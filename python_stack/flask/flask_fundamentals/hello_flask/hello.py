from flask import Flask, render_template  # Import Flask to allow us to create our app
app = Flask(__name__)    # Create a new instance of the Flask class called "app"
@app.route('/')                           
def index():
    return render_template("index.html", phrase="hello", times=5)	# notice the 2 new named arguments!
def hello_world():
    # Instead of returning a string, 
    # we'll return the result of the render_template method, passing in the name of our HTML file
    return render_template('index.html')  
    
# @app.route('/')          # The "@" decorator associates this route with the function immediately following
# def hello_world():
#     return 'Hello World!'  # Return the string 'Hello World!' as a response

@app.route('/dojo')
def dojo():
  return "Dojo!"
    
@app.route('/success')
def success():
  return "success"
    
@app.route('/say/<name>') # for a route '/hello/____' anything after '/hello/' gets passed as a variable 'name'
def hello(name):
    # print(name.capitalize())
    return "Hi " + name.capitalize()

@app.route('/repeat/<int:n>/<word>') # for a route '/users/____/____', two parameters in the url get passed as username and id
def repeat_word(n, word):
    word_w_space = word + ' '
    return n * word_w_space
    # return "username: " + username + ", id: " + id

# app name 
@app.errorhandler(404) 
  
# inbuilt function which takes error as parameter 
def not_found(e): 
  
# defining function 
  return "Sorry, not found on this server." 

if __name__=="__main__":   # Ensure this file is being run directly and not from a different module    
    app.run(debug=True)    # Run the app in debug mode.
