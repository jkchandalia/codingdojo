from django.db import models
import re

# Create your models here.

class ShowManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        # add keys and values to errors dictionary for each invalid field
        if len(postData['title']) < 2:
            errors["title"] = "Title should have at least 2 characters"
        if len(postData['network']) < 3:
            errors["network"] = "Network should have at least 3 characters"
        if len(postData['release_date'])<6:
            errors["release_date"] = "Valid release date must be entered"
        if len(postData['desc']) < 10 & len(postData['desc']) != 0:
            errors["desc"] = "Description should have at least 10 characters"
    
        return errors


class Show(models.Model):
    title = models.CharField(max_length=255)
    network = models.CharField(max_length=255)
    desc = models.TextField()
    release_date = models.DateField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = ShowManager()

