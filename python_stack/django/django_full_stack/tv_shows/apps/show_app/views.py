from django.shortcuts import render, redirect
from django.http import HttpResponse
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
    title = request.POST['title']
    network = request.POST['network']
    release_date = request.POST['release_date']
    desc = request.POST['desc']
    Show.objects.create(title=title, network=network, release_date=release_date, desc=desc)
    new_show = Show.objects.get(title=title)
    return redirect(f"/shows/{new_show.id}")

def update(request, show_id):
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
