from django.db import models
from apps.login_app.models import User

# Create your models here.
class Message(models.Model):
    user = models.ForeignKey(User, related_name="message")
    message = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

class Comment(models.Model):
    user = models.ForeignKey(User, related_name="comment")
    message = models.ForeignKey(Message, related_name="comment")
    comment = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
