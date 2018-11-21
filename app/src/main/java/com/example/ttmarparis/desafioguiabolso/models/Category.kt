package com.example.ttmarparis.desafioguiabolso.models

data class Category(val id: String, val name: String, val icon_url: String, val url: String, val value: String)

/*
* Example:
* {
*   "category":["science"],
*   "icon_url":"https:\/\/assets.chucknorris.host\/img\/avatar\/chuck-norris.png",
*   "id":"jtibnb-mtuyluzqrwtodzw","url":"https:\/\/api.chucknorris.io\/jokes\/jtibnb-mtuyluzqrwtodzw",
*   "value":"Chuck Norris can divide by zero."
*  }
* */