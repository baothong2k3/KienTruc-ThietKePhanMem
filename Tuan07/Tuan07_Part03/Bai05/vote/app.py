from flask import Flask, render_template_string, request, redirect
import redis
import os

app = Flask(__name__)
redis_host = os.getenv("REDIS_HOST", "redis")
redis_client = redis.StrictRedis(host=redis_host, port=6379, db=0)

TEMPLATE = '''
<h1>Vote App</h1>
<form method="POST">
    <button name="vote" value="cats">Vote for Cats</button>
    <button name="vote" value="dogs">Vote for Dogs</button>
</form>
'''

@app.route("/", methods=["GET", "POST"])
def index():
    if request.method == "POST":
        vote = request.form.get("vote")
        redis_client.rpush("votes", vote)
        return redirect("/")
    return render_template_string(TEMPLATE)

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=80)
