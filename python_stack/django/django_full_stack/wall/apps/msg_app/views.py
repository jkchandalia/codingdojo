from django.shortcuts import render, redirect
from django.contrib import messages
from apps.login_app.models import *
from apps.msg_app.models import *
import datetime

# Create your views here.
def index(request):
    if 'logged_in' in request.session:
        context = {
            'all_msgs': Message.objects.all()
        }
        return render(request, "msg_app/wall.html",context)
    else:
        messages.error(request, "Please login or register")
        return redirect("/")

def post_message(request):
    user = User.objects.get(id=request.session['userid'])
    Message.objects.create(user=user, message=request.POST['msg'])
    return redirect("/wall")

def post_comment(request):
    user = User.objects.get(id=request.session['userid'])
    message=Message.objects.get(id=request.POST['post_id'])
    Comment.objects.create(user=user, message=message, comment=request.POST['comment'])
    print(Comment.objects.all().values())
    return redirect("/wall")

def delete(request):
    msg = Message.objects.get(id=request.POST['delete'])
    userid = msg.user.id
    if userid==request.session['userid']:
        msg.delete()
    return redirect("/wall")