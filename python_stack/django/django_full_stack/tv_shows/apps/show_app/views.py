from django.shortcuts import render, redirect
from django.http import HttpResponse
from django.contrib import messages
from apps.show_app.models import *


def index(request):
    return redirect("/shows")

def shows(request):
    context = {
        'all_shows': Show.objects.all(),
    }
    return render(request, "show_app/shows.html", context)


def new_show(request):
    if request.method=="GET":
        return render(request, "show_app/new_show.html")
    
def create(request):
    errors = Show.objects.basic_validator(request.POST)
        # check if the errors dictionary has anything in it
    if len(errors) > 0:
        # if the errors dictionary contains anything, loop through each key-value pair and make a flash message
        for key, value in errors.items():
            messages.error(request, value)
        # redirect the user back to the form to fix the errors
        return redirect('/shows/new')
    num_results = Show.objects.filter(title = request.POST['title']).count()
    if num_results>0:
        messages.error(request, "A show with this title already exists.")
        return redirect('/shows/new')
    else:
        title = request.POST['title']
        network = request.POST['network']
        release_date = request.POST['release_date']
        desc = request.POST['desc']
        Show.objects.create(title=title, network=network, release_date=release_date, desc=desc)
        new_show = Show.objects.get(title=title)
        return redirect(f"/shows/{new_show.id}")

def update(request, show_id):
    errors = Show.objects.basic_validator(request.POST)
        # check if the errors dictionary has anything in it
    if len(errors) > 0:
        # if the errors dictionary contains anything, loop through each key-value pair and make a flash message
        for key, value in errors.items():
            messages.error(request, value)
        # redirect the user back to the form to fix the errors
        return redirect(f'/shows/{show_id}/edit')
    else:
        original_show = Show.objects.get(id=show_id)
        original_show.title = request.POST['title']
        original_show.network = request.POST['network']
        original_show.release_date = request.POST['release_date']
        original_show.desc = request.POST['desc']
        original_show.save()
        return redirect(f"/shows/{original_show.id}")
    
def destroy(request, show_id):
    Show.objects.get(id=show_id).delete()
    return redirect(f"/shows")


def show(request, show_id):
    context = {
        'show_info': Show.objects.get(id=show_id)
    }
    return render(request, "show_app/show.html", context)

def edit_show(request, show_id):
    context = {
        'show_info': Show.objects.get(id=show_id)
    }
    return render(request, "show_app/edit_show.html", context)
