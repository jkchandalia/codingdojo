from django.conf.urls import url, include
from django.contrib import admin
from . import views

urlpatterns = [
    # url(r'^admin/', admin.site.urls),
    url(r'^$', views.index),
    url(r'^authors$', views.authors),
    url(r'^books$', views.index),
    url(r'^book/(?P<book_id>\d+)$', views.book),
    url(r'^author/(?P<author_id>\d+)$', views.author),
    url(r'^author/delete/(?P<author_id>\d+)$', views.delete_author),
    url(r'^book/delete/(?P<book_id>\d+)$', views.delete_book),
    ]
