from django.conf.urls import url, include
from . import views

urlpatterns = [
    #url(r'^admin/', admin.site.urls),
    url(r'^$', views.index),
    url(r'^shows$', views.shows),
    url(r'^shows/new$', views.new_show),
    url(r'^shows/(?P<show_id>\d+)$', views.show),
    url(r'^shows/(?P<show_id>\d+)/$', views.show),
    url(r'^shows/(?P<show_id>\d+)/edit$', views.edit_show),
    url(r'^shows/(?P<show_id>\d+)/edit/$', views.edit_show),
    url(r'^shows/create$', views.create),
    url(r'^shows/(?P<show_id>\d+)/update$', views.update),
    url(r'^shows/(?P<show_id>\d+)/destroy$', views.destroy),
]
