from django.conf.urls import url, include
#from django.contrib import admin
from . import views
urlpatterns = [
#    url(r'^admin/', admin.site.urls),
    url(r'^$', views.books),
    url(r'^add_book$', views.add_book),
    url(r'^(?P<book_id>\d+)$', views.book),
    url(r'^update_book$', views.update_book),
    url(r'^delete_book$', views.delete_book),
    url(r'^favorite/(?P<book_id>\d+)$', views.favorite),
    url(r'^unfavorite/(?P<book_id>\d+)$', views.unfavorite),
    url(r'^user$', views.user),
]
