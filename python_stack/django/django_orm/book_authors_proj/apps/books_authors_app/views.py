from django.shortcuts import render, redirect, HttpResponse
from apps.books_authors_app.models import *

# Create your views here.
def index(request):
    if request.method=="GET":
        context = {"all_books": Book.objects.all()}
        print(Book.objects.all().values())
        return render(request, "books_authors_app/index.html", context)
    if request.method=="POST":
        title = request.POST['title']
        desc = request.POST['desc']
        Book.objects.create(title=title, desc=desc)
        return redirect("/")

def authors(request):
    if request.method=="GET":
        context = {"all_authors": Author.objects.all()}
        return render(request, "books_authors_app/authors.html", context)
    if request.method=="POST":
        first_name = request.POST['first_name']
        last_name = request.POST['last_name']
        notes = request.POST['notes']
        Author.objects.create(first_name=first_name, last_name=last_name, notes=notes)
        return redirect("/authors")

def author(request, author_id):
    if request.method=="GET":
        context = {"author_info": Author.objects.get(id=author_id),
                    "all_books": Book.objects.all()}
        return render(request, "books_authors_app/author.html", context)
    if request.method=="POST":
        author = Author.objects.get(id=author_id)
        author.books.add(Book.objects.get(id=request.POST["book_id"]))
        return redirect("/author/"+str(author_id))

def book(request, book_id):
    if request.method=="GET":
        context = {"book_info": Book.objects.get(id=book_id),
                    "all_authors": Author.objects.all()}
        return render(request, "books_authors_app/book.html", context)
    if request.method=="POST":
        book = Book.objects.get(id=book_id)
        book.authors.add(Author.objects.get(id=request.POST["author_id"]))
        return redirect("/book/"+str(book_id))

def delete_author(request, author_id):
    author = Author.objects.get(id=author_id)
    author.delete()
    return redirect("/authors")