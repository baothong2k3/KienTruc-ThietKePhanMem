import os

STATIC_URL = '/static/'
SECRET_KEY = 'dummy'
DEBUG = True
ALLOWED_HOSTS = []

INSTALLED_APPS = [
    'django.contrib.contenttypes',
    'django.contrib.staticfiles',
    'app',
]

MIDDLEWARE = []
ROOT_URLCONF = 'django_project.urls'
WSGI_APPLICATION = 'django_project.wsgi.application'

DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.sqlite3',
        'NAME': os.path.join(os.path.dirname(__file__), '..', 'db.sqlite3'),
    }
}

CELERY_BROKER_URL = 'redis://redis:6379/0'
