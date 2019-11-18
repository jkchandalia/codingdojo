from django.conf.urls import url, include
#from django.contrib import admin
from . import views
urlpatterns = [
#    url(r'^admin/', admin.site.urls),
    url(r'^$', views.dashboard),
    url(r'^dashboard$', views.dashboard),
    url(r'^edit/(?P<trip_id>\d+)$', views.edit),
    url(r'^new$', views.new),
    url(r'^(?P<trip_id>\d+)$', views.show_trip),
    url(r'^add_trip$', views.add_trip),
    url(r'^delete_trip/(?P<trip_id>\d+)$', views.delete_trip),
    url(r'^remove_trip/(?P<trip_id>\d+)$', views.remove_trip),
    url(r'^join_trip/(?P<trip_id>\d+)$', views.join_trip),
    url(r'^edit_trip$', views.edit_trip),
]
