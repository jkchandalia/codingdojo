users.objects.create(first_name="jay", last_name='z', age=45, email_address="jayz@jaze.com")
users.objects.create(first_name="queen", last_name='bey', age=37, email_address="queen@beyonce.com")
users.objects.create(first_name="riri", last_name='Fenty', age=32, email_address="otherqueen@riri.com")

users.objects.all()

users.objects.get(id=3)

users.objects.get(id=3).first_name

users.objects.all().last().first_name 
users.objects.all().first().first_name 
user = users.objects.get(id=3)
user.last_name="Pancakes"
user.save()

user = users.objects.get(id=2)
user.delete()

users.objects.all().order_by("first_name")

users.objects.all().order_by("-first_name")