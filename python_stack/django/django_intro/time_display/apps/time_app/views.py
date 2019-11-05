from django.shortcuts import render, redirect, HttpResponse
from time import gmtime, strftime

def index(request):
    data = {'datetime': strftime("%b %d, %Y %H:%M %p", gmtime())}
    return render(request,"time_app/index.html", data)
 
def time_display(request):
    return redirect("/")
# def index(request):
#     context = {
#         "time": strftime("%Y-%m-%d %H:%M %p", gmtime())
#     }
#     return render(request,'appname/index.html', context)
