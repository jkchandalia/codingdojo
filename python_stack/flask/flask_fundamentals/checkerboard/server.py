from flask import Flask, render_template  # Import Flask to allow us to create our app
app = Flask(__name__)    # Create a new instance of the Flask class called "app"

@app.route('/')
def index():
    return render_template("index.html", ynum=8, xnum=8)

@app.route('/<int:ynum>')
def index_x(ynum):
    return render_template("index.html", ynum=ynum, xnum=8)

@app.route('/<int:ynum>/<int:xnum>')
def index_x_y(ynum, xnum):
    return render_template("index.html", ynum=ynum, xnum=xnum)

# app name 
@app.errorhandler(404) 
def not_found(e): 
  return "Sorry, not found on this server." 

if __name__=="__main__":   # Ensure this file is being run directly and not from a different module    
    app.run(debug=True)    # Run the app in debug mode.
