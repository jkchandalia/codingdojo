from flask import Flask, render_template, request, redirect # added request
app = Flask(__name__)
            
# our index route will handle rendering our form
@app.route('/')
def index():
    return render_template("index.html")

@app.route('/users', methods=['POST'])
def create_user():
    print("Got User Info")
    print(request.form)
    name= request.form['name'].capitalize()
    location = request.form['location'].capitalize()
    language = request.form['language'].capitalize()
    comment = request.form['comment']
    gender = request.form['gender']
    commute = request.form.getlist('commute')
    return render_template("results.html", name=name, location=location, language=language,comment=comment, gender=gender, commute=', '.join(commute))


if __name__ == "__main__":
    app.run(debug=True)
    
