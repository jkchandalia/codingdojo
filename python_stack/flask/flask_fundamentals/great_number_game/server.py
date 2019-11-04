from flask import Flask, render_template, request, redirect, session# added request
import random
app = Flask(__name__)
app.secret_key = 'keep it secret, keep it safe' # set a secret key for security purposes            
# our index route will handle rendering our form
@app.route('/')
def index():
    if 'number' not in session:
        session['number'] = random.randint(0,100)
    return render_template("index.html")

@app.route('/destroy_session')
def destroy_session():
    session.clear()
    return redirect('/')

@app.route('/guess', methods=["POST"])
def check_guess():
    if "num_guesses" not in session:
        session["num_guesses"] = 1
    else:
        session["num_guesses"]+=1
    if int(request.form['guess']) > session['number']:
        session["guess"] = "too high"
    elif int(request.form['guess']) < session['number']:
        session["guess"] = "too low"
    else:
        session["guess"] = "equal"
    return redirect("/")

@app.route('/play_again', methods=["POST"])
def play_again():
    if request.form["play_again"] in ('y','Y', 'yes', 'Yes'):
        return redirect('/destroy_session')

if __name__ == "__main__":
    app.run(debug=True)
    
