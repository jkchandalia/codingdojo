from django.shortcuts import render, redirect
from apps.login_app.models import *
from apps.books_app.models import *
from django.contrib import messages

# Create your views here.
def books(request):
    context = {
        'books':Book.objects.all(),
        'user' :User.objects.get(id=request.session['userid'])
    }
    return render(request, "books_app/books.html", context)

def add_book(request):
    errors = Book.objects.basic_validator(request.POST)
    if len(errors) > 0:
        # if the errors dictionary contains anything, loop through each key-value pair and make a flash message
        for key, value in errors.items():
            messages.error(request, value)
        # redirect the user back to the form to fix the errors
        return redirect('/books')
    else:
        user = User.objects.get(id=request.session['userid'])
        print('got user')
        Book.objects.create(title=request.POST['title'], desc=request.POST['desc'], uploaded_by=user)
        book=Book.objects.filter(title=request.POST['title'])[0]
        book.users_who_like.add(user)
        print('made book')
        return redirect(f'/books/{book.id}')

def book(request, book_id):
    book = Book.objects.get(id=book_id)
    user = User.objects.get(id=request.session['userid'])
    if user in book.users_who_like.all():
        fav = 'y'
    else:
        fav = 'n'
    context = {
        'book': Book.objects.get(id=book_id),
        'fav' : fav,
    }
    if request.session['userid'] == book.uploaded_by.id:
        return render(request, "books_app/book_edit.html",context)
    else:
        return render(request, "books_app/book.html",context)


def update_book(request):
    book = Book.objects.get(id=request.POST['book_id'])
    errors = Book.objects.basic_validator(request.POST)
    if len(errors) > 0:
        # if the errors dictionary contains anything, loop through each key-value pair and make a flash message
        for key, value in errors.items():
            messages.error(request, value)
        # redirect the user back to the form to fix the errors
    else:
        book.title = request.POST['title']
        book.desc = request.POST['desc']
        book.save()
    return redirect(f'/books/{book.id}')


def delete_book(request):
    book = Book.objects.get(id=request.POST['book_id'])
    book.delete()
    return redirect("/books")

def favorite(request, book_id):
    user=User.objects.get(id=request.session['userid'])
    book=Book.objects.get(id=book_id)
    book.users_who_like.add(user)
    book.save()
    return redirect(f"/books/{book_id}")

def unfavorite(request, book_id):
    user=User.objects.get(id=request.session['userid'])
    book=Book.objects.get(id=book_id)
    book.users_who_like.remove(user)
    book.save()
    return redirect(f"/books/{book_id}")

def user(request):
    user = User.objects.get(id=request.session['userid'])
    context={
        'favbooks': user.liked_books.all()
    }
    return render(request,"books_app/user.html", context)