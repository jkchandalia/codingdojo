from django.conf.urls import url
from . import views
# from django.contrib import admin

urlpatterns = [
    url(r'^$', views.index),
    url(r'^process_money$', views.process_money),
    url(r'^destroy_session$', views.destroy_session)
]
