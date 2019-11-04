from flask import Flask, render_template, request, redirect, session# added request
app = Flask(__name__)
app.secret_key = 'keep it secret, keep it safe' # set a secret key for security purposes            
# our index route will handle rendering our form
@app.route('/')
def index():
    if 'counter' in session:
        session['counter'] = session['counter'] + 1
    else:
        session['counter']=1
    if 'real_counter' in session:
        session['real_counter'] = session['real_counter'] + 1
    else:
        session['real_counter']=1

    return render_template("index.html")

@app.route('/destroy_session')
def destroy_session():
    session.clear()
    return redirect('/')

@app.route('/counter2')
def counter_add_2():
    session['counter']+=1
    return redirect('/')

@app.route('/increment')
def increment():
    session['counter'] = session['counter']+session['incrementor']-1
    return redirect('/')

@app.route('/counter_increment', methods=["POST"])
def increment_counter():
    session['incrementor']=int(request.form["increment"])
    return redirect('/')

@app.route('/reset_counter')
def reset_counter():
    session['counter']=0
    return redirect('/')
# session.pop('key_name')		

if __name__ == "__main__":
    app.run(debug=True)
    
