package com.dicoding.githubclone.localdata

import com.dicoding.githubclone.data.Profiles
import com.dicoding.githubclone.R

object ProfilesData {
    private val fullNames = arrayOf(
        "Alex Crichton",
        "Andrew Nesbitt",
        "Eren Bets",
        "Fabien Potencier",
        "jongleberry",
        "Juho Vepsäläinen",
        "Mike McNeil",
        "Nelson",
        "Taylor Otwell",
        "Thibault Duplessis"
    )

    private val usernames = arrayOf(
        "alexcrichton",
        "andrew",
        "egoist",
        "fabpot",
        "jonathanong",
        "bebraw",
        "mikermcneil",
        "nelsonic",
        "taylorotwell",
        "ornicar"
    )

    private val bios = arrayOf(
        "",
        "Software engineer and researcher",
        "Kami sama desu.",
        "",
        "@expressjs @koajs @jshttp @pillarjs",
        "I am behind the @survivejs effort.",
        "CEO, Fleet. Creator & BDFL of sails.js",
        "Love learning code @dwyl Systematic about sharing all knowledge/skills. Learn something new every day.",
        "Creator of @laravel.",
        "Maker of lichess.org, a hippie communist chess server for drug fueled atheists."
    )
    private val profilePictures = arrayOf(
        R.drawable.alex_crichton,
        R.drawable.andrew_nesbitt,
        R.drawable.eren_bets,
        R.drawable.fabien_potencier,
        R.drawable.jonathan_ong,
        R.drawable.juho_vepsalainen,
        R.drawable.mike_mcneil,
        R.drawable.nelsonic,
        R.drawable.taylor_otwell,
        R.drawable.thibault_duplessis
    )

    val listData: ArrayList<Profiles>
    get(){
        val list = arrayListOf<Profiles>()
        for (position in fullNames.indices){
            val profile = Profiles()
            profile.fullName = fullNames[position]
            profile.username = usernames[position]
            profile.bio = bios[position]
            profile.profilePicture = profilePictures[position]
            list.add(profile)
        }
        return list
    }
}