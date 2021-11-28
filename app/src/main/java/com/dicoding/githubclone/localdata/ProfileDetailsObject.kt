package com.dicoding.githubclone.localdata

import com.dicoding.githubclone.R

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
                    "fabpot" to "\uD83D\uDE00"
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
                    "fabpot" to "Symfony/Blackfire"
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
                    "fabpot" to "Lille, France"
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
                    "fabpot" to "http://fabien.potencier.org/"
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
                    "fabpot" to "11.3k followers · 0 following"
            )
            return followStatsDetail
        }

    val repositoryNameDetails: Map<String,String>
        get(){
            val repositoryNameDetail = mapOf(
                    "mikermcneil" to "sail",
                    "jonathanong" to "koa",
                    "alexcrichton" to "rust-ffi-examples",
                    "nelsonic" to "start-here",
                    "bebraw" to "react-book",
                    "ornicar" to "lila",
                    "egoist" to "saber",
                    "taylorotwell" to "laravel",
                    "andrew" to "octobox",
                    "fabpot" to "symfony"
            )
            return repositoryNameDetail
        }

    val repositoryDescriptionDetails: Map<String,String>
        get(){
            val repositoryDescriptionDetail = mapOf(
                    "mikermcneil" to "Realtime MVC Framework for Node.js",
                    "jonathanong" to "Expressive middleware for node.js using ES2017 async functions",
                    "alexcrichton" to "FFI examples written in Rust",
                    "nelsonic" to "\uD83D\uDCA1 A Quick-start Guide for People who want to dwyl ❤️ ✅",
                    "bebraw" to "From apprentice to master (CC BY-NC-ND)",
                    "ornicar" to "♞ lichess.org: the forever free, adless and open source chess server ♞",
                    "egoist" to "()==[:::::::::::::> Build static sites in Vue.js, without the hassle",
                    "taylorotwell" to "A PHP framework for web artisans",
                    "andrew" to "\uD83D\uDCEEUntangle your GitHub Notifications",
                    "fabpot" to "The Symfony PHP framework"
            )
            return repositoryDescriptionDetail
        }

    val starNumberDetails: Map<String,String>
        get(){
            val starNumberDetail = mapOf(
                    "mikermcneil" to "21.869",
                    "jonathanong" to "30.888",
                    "alexcrichton" to "831",
                    "nelsonic" to "1.390",
                    "bebraw" to "2.010",
                    "ornicar" to "8.596",
                    "egoist" to "2.059",
                    "taylorotwell" to "64.331",
                    "andrew" to "4.027",
                    "fabpot" to "24.782"
            )
            return starNumberDetail
        }

    val programmingLanguageDetails: Map<String,String>
        get(){
            val programLanguageDetail = mapOf(
                    "mikermcneil" to "JavaScript",
                    "jonathanong" to "JavaScript",
                    "alexcrichton" to "Makefile",
                    "nelsonic" to "Unknown",
                    "bebraw" to "JavaScript",
                    "ornicar" to "Scala",
                    "egoist" to "JavaScript",
                    "taylorotwell" to "PHP",
                    "andrew" to "Ruby",
                    "fabpot" to "PHP"
            )
            return programLanguageDetail
        }

    val programmingLanguageVectorDetails: Map<String,Int>
        get(){
            val programLanguageVectorDetail = mapOf(
                    "mikermcneil" to R.drawable.javascript,
                    "jonathanong" to R.drawable.javascript,
                    "alexcrichton" to R.drawable.makefile,
                    "nelsonic" to R.drawable.unknown,
                    "bebraw" to R.drawable.javascript,
                    "ornicar" to R.drawable.scala,
                    "egoist" to R.drawable.javascript,
                    "taylorotwell" to R.drawable.php,
                    "andrew" to R.drawable.ruby,
                    "fabpot" to R.drawable.php
            )
            return programLanguageVectorDetail
        }

    val repositoriesNumber: Map<String,String>
        get(){
            val repoNumber = mapOf(
                    "mikermcneil" to "212",
                    "jonathanong" to "60",
                    "alexcrichton" to "407",
                    "nelsonic" to "299",
                    "bebraw" to "183",
                    "ornicar" to "380",
                    "egoist" to "722",
                    "taylorotwell" to "18",
                    "andrew" to "298",
                    "fabpot" to "55"
            )
            return repoNumber
        }

    val starredNumber: Map<String,String>
        get(){
            val starNumber = mapOf(
                    "mikermcneil" to "286",
                    "jonathanong" to "148",
                    "alexcrichton" to "34",
                    "nelsonic" to "3.434",
                    "bebraw" to "2.596",
                    "ornicar" to "662",
                    "egoist" to "2.988",
                    "taylorotwell" to "195",
                    "andrew" to "6.112",
                    "fabpot" to "157"
            )
            return starNumber
        }

    val organizationsNumber: Map<String,String>
        get(){
            val orgNumber = mapOf(
                    "mikermcneil" to "5",
                    "jonathanong" to "4",
                    "alexcrichton" to "4",
                    "nelsonic" to "4",
                    "bebraw" to "3",
                    "ornicar" to "0",
                    "egoist" to "3",
                    "taylorotwell" to "2",
                    "andrew" to "10",
                    "fabpot" to "9"
            )
            return orgNumber
        }


}