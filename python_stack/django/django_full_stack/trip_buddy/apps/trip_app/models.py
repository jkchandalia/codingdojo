from django.db import models
import re
from apps.login_app.models import User
import datetime


# Create your models here.
class TripManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        # add keys and values to errors dictionary for each invalid field
        if len(postData['destination'])<3:
            errors['destination'] = "Destination should be at least 3 characters"
        if len(postData['plan'])<3:
            errors['plan'] = "Plan should be at least 3 characters"            
        if len(postData['start_date'])<7:
            errors['start_date'] = "Please enter a valid date"
        if len(postData['end_date'])<7:
            errors['end_date'] = "Please enter a valid date"
        now = datetime.datetime.now()
        try:
            start = datetime.datetime.strptime(postData['start_date'], '%Y-%m-%d')
            if start<now:
                errors['start_date'] = "Please enter a date in the future"
        except ValueError:
            errors['start_date'] = "Please a valid date format"
        try:
            end = datetime.datetime.strptime(postData['end_date'], '%Y-%m-%d')
            if end<now:
                errors['end_date'] = "Please ensure end date is after start date"
        except ValueError:
            errors['end_date'] = "Please a valid date format"

        print(postData['start_date'])
        print(type(postData['start_date']))

        return errors


class Trip(models.Model):
    destination = models.CharField(max_length=255)
    start_date = models.DateField()
    end_date = models.DateField()
    plan = models.TextField()
    created_by = models.ForeignKey(User, related_name="trips_created")
    members = models.ManyToManyField(User, related_name="trips_joined")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = TripManager()
