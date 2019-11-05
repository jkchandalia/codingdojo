from flask import Flask, render_template, request, redirect, session# added request
import random, time
app = Flask(__name__)
app.secret_key = 'keep it secret, keep it safe' # set a secret key for security purposes            
# our index route will handle rendering our form
@app.route('/')
def index():
    if 'gold' not in session:
        session['gold'] = 0
        session['activities']=[]
    return render_template("index.html")

@app.route('/destroy_session')
def destroy_session():
    session.clear()
    return redirect('/')

@app.route('/process_money', methods=["POST"])
def process_money():
    str_format=('%Y/%m/%d %H:%M %p')
    gold_lookup_dict = {"farm": random.randint(10,20),
                    "cave":  random.randint(5,10),
                    "house": random.randint(2,5),
                    "casino": 0-random.randint(0,50)}
    key = request.form["building"]
    gold_earned = gold_lookup_dict[key]
    session['gold']+=gold_earned
    if key in ("farm", "cave", "house"):
        activity_str = "<div class='green'> Earned "+str(gold_earned)+" golds from the "+key+"! ("+time.strftime(str_format)+")</div>"
    elif key == "casino":
        activity_str = "<div class='red'> Entered a "+key+" and lost "+str(gold_earned)+" golds... Ouch.. ("+time.strftime(str_format)+")</div>"
    session['activities'].append(activity_str)
    return redirect("/")

@app.route('/play_again', methods=["POST"])
def play_again():
    if request.form["play_again"] in ('y','Y', 'yes', 'Yes'):
        return redirect('/destroy_session')

if __name__ == "__main__":
    app.run(debug=True)
    
