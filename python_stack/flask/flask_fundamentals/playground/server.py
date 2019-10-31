from flask import Flask, render_template  # Import Flask to allow us to create our app
app = Flask(__name__)    # Create a new instance of the Flask class called "app"

@app.route('/play/<int:num>')
def render_num_boxes(num):
    return render_template("play.html", num=num)

@app.route('/play')                           
def render_3_boxes():
    return render_template("play.html", num=3)	# notice the 2 new named arguments!

@app.route('/play/<int:num>/<color>')
def render_num_boxes_color(num, color):
    return render_template("play.html", num=num, color=color)

# app name 
@app.errorhandler(404) 
def not_found(e): 
  return "Sorry, not found on this server." 

if __name__=="__main__":   # Ensure this file is being run directly and not from a different module    
    app.run(debug=True)    # Run the app in debug mode.
