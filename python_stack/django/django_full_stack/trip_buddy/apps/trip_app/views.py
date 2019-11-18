from django.shortcuts import render, redirect
from apps.login_app.models import *
from apps.trip_app.models import *
from django.contrib import messages


# Create your views here.
#def index(request):
#    return redirect("dashboard")

def dashboard(request):
    user = User.objects.get(id=request.session['userid'])
    user_trips = user.trips_joined.all()
    all_trips = Trip.objects.all()
    other_trips=set(all_trips)-set(user_trips)
    context = {
        'trips' : user_trips,
        'other_trips': other_trips,
    }
    return render(request, 'trips_app/trips.html', context)

def edit(request, trip_id):
    trip = Trip.objects.get(id=trip_id)
    context = {
        'trip': trip
    }
    return render(request, 'trips_app/trip_edit.html', context)

def new(request):
    return render(request, 'trips_app/new.html')

def show_trip(request, trip_id):
    trip = Trip.objects.get(id=trip_id)
    context = {
        'trip': trip
    }
    return render(request, 'trips_app/trip.html', context)

def add_trip(request):
    errors = Trip.objects.basic_validator(request.POST)
    # check if the errors dictionary has anything in it
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        # redirect the user back to the form to fix the errors
        return redirect("/trips/new")
    else:
        destination = request.POST['destination']
        start_date = request.POST['start_date']
        end_date = request.POST['end_date']
        plan = request.POST['plan']
        user=User.objects.get(id=request.session['userid'])
        new_trip = Trip.objects.create(
            destination=destination,
            start_date=start_date,
            end_date=end_date,
            plan=plan,
            created_by=user
        )
        
        new_trip.members.add(user)
        return redirect("/trips")

def edit_trip(request):
    errors = Trip.objects.basic_validator(request.POST)
    # check if the errors dictionary has anything in it
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        # redirect the user back to the form to fix the errors
        return redirect(f"/trips/edit/{request.POST['trip_id']}")
    else:
        trip_id = request.POST['trip_id']
        trip = Trip.objects.get(id=trip_id)
        trip.destination = request.POST['destination']
        trip.start_date = request.POST['start_date']
        trip.end_date = request.POST['end_date']
        trip.plan = request.POST['plan']
        trip.save()
    return redirect("/trips")

def delete_trip(request, trip_id):
    trip = Trip.objects.get(id=trip_id)
    trip.delete()
    return redirect("/trips")

def remove_trip(request, trip_id):
    trip = Trip.objects.get(id=trip_id)
    user = User.objects.get(id=request.session['userid'])
    user.trips_joined.remove(trip)
    return redirect("/trips")

def join_trip(request, trip_id):
    trip = Trip.objects.get(id=trip_id)
    user = User.objects.get(id=request.session['userid'])
    user.trips_joined.add(trip)
    return redirect("/trips")