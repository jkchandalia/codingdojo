# C Sharp, Java, Python, PHP, Ruby
Book.objects.create(title="C#")
Book.objects.create(title="Java")
Book.objects.create(title="Python")
Book.objects.create(title="PHP")
Book.objects.create(title="Ruby")

# Jane Austen, Emily Dickinson, Fyodor Dostoevksy, William Shakespeare, Lau Tzu
Author.objects.create(first_name="Jane", last_name="Austen")
Author.objects.create(first_name="Emily", last_name="Dickinson")
Author.objects.create(first_name="Fyodor", last_name="Dostoevsky")
Author.objects.create(first_name="William", last_name="Shakespeare")
Author.objects.create(first_name="Lau", last_name="Tzu")

book = Book.objects.get(title="C#")
book.title = "C real #"
book.save()

author = Author.objects.get(id=4)
author.first_name = "Bill"
author.save()

author1 = Author.objects.get(id=1)
book1 = Book.objects.get(id=1)
book2 = Book.objects.get(id=2)
author1.books.add(book1)
author1.books.add(book2)

author2 = Author.objects.get(id=2)
book3 = Book.objects.get(id=3)
author2.books.add(book1)
author2.books.add(book2)
author2.books.add(book3)

author3 = Author.objects.get(id=3)
book4 = Book.objects.get(id=4)
author3.books.add(book1)
author3.books.add(book2)
author3.books.add(book3)
author3.books.add(book4)

#Any way to assign all in one line?
author4 = Author.objects.get(id=4)
book5 = Book.objects.get(id=5)
author4.books.add(book1)
author4.books.add(book2)
author4.books.add(book3)
author4.books.add(book4)
author4.books.add(book5)

book3.authors.all().values()

#can we count on order when retrieving records?
book3.authors.remove(book3.authors.all().first())
book3.authors.all().values()

book2.authors.add(Author.objects.get(id=5))

author3.books.all().values()

Book.objects.get(id=5).authors.all().values()