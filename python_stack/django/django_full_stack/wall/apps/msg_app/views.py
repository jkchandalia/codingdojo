from django.shortcuts import render, redirect
from apps.login_app.models import *
from apps.msg_app.models import *

# Create your views here.
def index(request):
    context = {
        'all_msgs': Message.objects.all()
    }
    return render(request, "msg_app/wall.html",context)

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