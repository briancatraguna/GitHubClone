package com.dicoding.githubclone

object ProfileDetailsObject {
    val descriptionDetail: Map<String,String>
        get(){
            val descDetail = mapOf(
                    "mikermcneil" to "\uD83E\uDDD1\u200D\uD83D\uDE80",
                    "jonathanong" to " - ",
                    "alexcrichton" to " - ",
                    "nelsonic" to "\uD83D\uDCAD",
                    "bebraw" to " - ",
                    "ornicar" to "\uD83D\uDCAD",
                    "egoist" to "\uD83C\uDFE0",
                    "taylorotwell" to "\uD83C\uDFC4\u200D♂️",
                    "andrew" to "\uD83D\uDC29",
                    "fabpot" to "\uD83D\uDE00",
                    "feryandi" to "\uD83D\uDC77\u200D♂️"
            )
            return descDetail
        }

    val companyDetail: Map<String,String>
        get(){
            val compDetail = mapOf(
                    "mikermcneil" to "Fleet (@fleetdm)",
                    "jonathanong" to "@Houzz",
                    "alexcrichton" to " - ",
                    "nelsonic" to "@dwyl",
                    "bebraw" to "@survivejs",
                    "ornicar" to "lichess.org",
                    "egoist" to " - ",
                    "taylorotwell" to "Laravel",
                    "andrew" to " - ",
                    "fabpot" to "Symfony/Blackfire",
                    "feryandi" to "Carnegie Mellon University"
            )
            return compDetail
        }

    val locationDetail: Map<String,String>
        get(){
            val locDetail = mapOf(
                    "mikermcneil" to "Austin, Texas",
                    "jonathanong" to "Los Angeles, CA",
                    "alexcrichton" to " - ",
                    "nelsonic" to "London",
                    "bebraw" to "Vienna, Austria",
                    "ornicar" to "France",
                    "egoist" to "China",
                    "taylorotwell" to "Little Rock, AR",
                    "andrew" to "UK",
                    "fabpot" to "Lille, France",
                    "feryandi" to "United States"
            )
            return locDetail
        }


    val linkDetail: Map<String,String>
        get(){
            val linkDetail = mapOf(
                    "mikermcneil" to "linkedin.com/in/mikermcneil",
                    "jonathanong" to "https://jongleberry.com",
                    "alexcrichton" to " - ",
                    "nelsonic" to "https://dwyl.com",
                    "bebraw" to "https://survivejs.com/",
                    "ornicar" to "https://lichess.org",
                    "egoist" to "https://egoist.sh",
                    "taylorotwell" to "http://laravel.com",
                    "andrew" to "https://nesbitt.io",
                    "fabpot" to "http://fabien.potencier.org/",
                    "feryandi" to "kutu.dev"
            )
            return linkDetail
        }

    val followStatsDetail: Map<String,String>
        get(){
            val followStatsDetail = mapOf(
                    "mikermcneil" to "2k followers · 225 following",
                    "jonathanong" to "2k followers · 144 following",
                    "alexcrichton" to "3.4k followers · 0 following",
                    "nelsonic" to "3.1k followers · 17.8k following",
                    "bebraw" to "1.9k followers · 0 following",
                    "ornicar" to "3.3k followers · 174 following",
                    "egoist" to "8.1k followers · 25 following",
                    "taylorotwell" to "21.6k followers · 0 following",
                    "andrew" to "2.6k followers · 3.2k following",
                    "fabpot" to "11.3k followers · 0 following",
                    "feryandi" to "52 followers · 7 following"
            )
            return followStatsDetail
        }

}