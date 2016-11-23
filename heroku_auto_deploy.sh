#!/bin/bash
heroku war:deploy ./target/*.war
heroku ps:scale web=1
heroku open


