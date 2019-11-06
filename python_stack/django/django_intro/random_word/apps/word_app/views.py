from django.shortcuts import render, redirect, HttpResponse
from django.utils.crypto import get_random_string

def index(request):
    random_str = get_random_string(14)
    data={
        'random_str': random_str
    }
    if 'attempt' not in request.session:
        request.session['attempt'] = 1
    else:
        request.session['attempt'] += 1
    return render(request, 'word_app/index.html', data)


def random_word(request):
    return redirect("/")

def reset(request):
    request.session.clear()
    return redirect("/")