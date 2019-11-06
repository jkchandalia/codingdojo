from django.shortcuts import render, redirect
import random
import time

# Create your views here.
def index(request):
    if "gold" not in request.session:
        request.session["gold"] = 0
        request.session['activities'] = []
    return render(request,'gold_app/index.html')

def process_money(request):
    str_format=('%Y/%m/%d %H:%M %p')
    gold_lookup_dict = {"farm": random.randint(10,20),
                    "cave":  random.randint(5,10),
                    "house": random.randint(2,5),
                    "casino": 0-random.randint(0,50)}
    key = request.POST["building"]
    gold_earned = gold_lookup_dict[key]
    request.session['gold']+=gold_earned
    if key in ("farm", "cave", "house"):
        activity_str = "<div class='green'> Earned "+str(gold_earned)+" golds from the "+key+"! ("+time.strftime(str_format)+")</div>"
    elif key == "casino":
        activity_str = "<div class='red'> Entered a "+key+" and lost "+str(gold_earned)+" golds... Ouch.. ("+time.strftime(str_format)+")</div>"
    request.session['activities'].append(activity_str)
    return redirect("/")

def destroy_session(request):
    request.session.clear()
    return redirect("/")