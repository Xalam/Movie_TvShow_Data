package com.xalam.movietvshowrepo.data.source;

import com.xalam.movietvshowrepo.R;
import com.xalam.movietvshowrepo.data.source.local.entity.MoviesEntity;
import com.xalam.movietvshowrepo.data.source.local.entity.TVShowsEntity;
import com.xalam.movietvshowrepo.data.source.remote.response.MoviesResponse;
import com.xalam.movietvshowrepo.data.source.remote.response.TvShowsResponse;

import java.util.ArrayList;
import java.util.List;

public class DataContent {
    public static List<MoviesEntity> generateMovies() {
        ArrayList<MoviesEntity> moviesEntities = new ArrayList<>();

        moviesEntities.add(new MoviesEntity(
                "m1",
                "Alita: Battle Angel",
                "2019",
                "02/14/2019",
                "Action, Science Fiction, Adventure",
                "2h 2m",
                R.drawable.poster_alita,
                "71",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "movie",
                null));

        moviesEntities.add(new MoviesEntity(
                "m2",
                "Aquaman",
                "2018",
                "12/21/2018",
                "Action, Adventure, Fantasy",
                "2h 24m",
                R.drawable.poster_aquaman,
                "69",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "movie",
                null));

        moviesEntities.add(new MoviesEntity(
                "m3",
                "A Star Is Born",
                "2018",
                "10/05/2018",
                "Drama, Romance, Music",
                "2h 16m",
                R.drawable.poster_a_start_is_born,
                "75",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "movie",
                null));

        moviesEntities.add(new MoviesEntity(
                "m4",
                "Bohemian Rhapsody",
                "2018",
                "11/02/2018",
                "Drama, Music",
                "2h 15m",
                R.drawable.poster_bohemian,
                "80",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "movie",
                null));

        moviesEntities.add(new MoviesEntity(
                "m5",
                "Cold Pursuit",
                "2019",
                "02/08/2019",
                "Action, Crime, Thriller",
                "1h 59m",
                R.drawable.poster_cold_persuit,
                "56",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "movie",
                null));

        moviesEntities.add(new MoviesEntity(
                "m6",
                "Creed II",
                "2018",
                "11/21/2018",
                "Drama",
                "2h 10m",
                R.drawable.poster_creed,
                "69",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "movie",
                null));

        moviesEntities.add(new MoviesEntity(
                "m7",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "2018",
                "11/16/2018",
                "Adventure, Fantasy, Drama",
                "2h 14m",
                R.drawable.poster_crimes,
                "69",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "movie",
                null));

        moviesEntities.add(new MoviesEntity(
                "m8",
                "Glass",
                "2019",
                "01/18/2019",
                "Thriller, Drama, Science Fiction",
                "2h 9m",
                R.drawable.poster_glass,
                "66",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "movie",
                null));

        moviesEntities.add(new MoviesEntity(
                "m9",
                "How to Train Your Dragon: The Hidden World",
                "2019",
                "02/22/2019",
                "Animation, Family, Adventure",
                "1h 44m",
                R.drawable.poster_how_to_train,
                "78",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "movie",
                null));

        moviesEntities.add(new MoviesEntity(
                "m10",
                "Avengers: Infinity War",
                "2018",
                "04/27/2018",
                "Drama",
                "2h 29m",
                R.drawable.poster_infinity_war,
                "83",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "movie",
                null));

        moviesEntities.add(new MoviesEntity(
                "m11",
                "Spider-Man: Into the Spider-Verse",
                "2018",
                "12/14/2018",
                "Action, Adventure, Animation, Science Fiction, Comedy",
                "1h 57m",
                R.drawable.poster_spiderman,
                "84",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "movie",
                null));

        return moviesEntities;
    }

    public static List<TVShowsEntity> generateTVShows() {
        ArrayList<TVShowsEntity> tvShowsEntities = new ArrayList<>();

        tvShowsEntities.add(new TVShowsEntity(
                "t1",
                "Arrow",
                "2012",
                "10/10/2012",
                "Crime, Drama, Mystery, Action & Adventure",
                "42m",
                R.drawable.poster_arrow,
                "65",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "tv",
                null));

        tvShowsEntities.add(new TVShowsEntity(
                "t2",
                "Dragon Ball",
                "1986",
                "02/26/1986",
                "Comedy, Sci-Fi & Fantasy, Animation, Action & Adventure",
                "25m",
                R.drawable.poster_dragon_ball,
                "80",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "tv",
                null));

        tvShowsEntities.add(new TVShowsEntity(
                "t3",
                "The Flash",
                "2014",
                "10/07/2014",
                "Drama, Sci-Fi & Fantasy",
                "44m",
                R.drawable.poster_flash,
                "76",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "tv", null));

        tvShowsEntities.add(new TVShowsEntity(
                "t4",
                "Gotham",
                "2014",
                "09/22/2014",
                "Drama, Fantasy, Crime",
                "43m",
                R.drawable.poster_gotham,
                "74",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "tv", null));

        tvShowsEntities.add(new TVShowsEntity(
                "t5",
                "Grey's Anatomy",
                "2005",
                "03/27/2005",
                "Drama",
                "43m",
                R.drawable.poster_grey_anatomy,
                "81",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "tv",
                null));

        tvShowsEntities.add(new TVShowsEntity(
                "t6",
                "Hanna",
                "2019",
                "03/28/2019",
                "Action & Adventure, Drama",
                "50m",
                R.drawable.poster_hanna,
                "74",
                "his thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "tv",
                null));

        tvShowsEntities.add(new TVShowsEntity(
                "t7",
                "Marvel's Iron Fist",
                "2017",
                "03/17/2017",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "55m",
                R.drawable.poster_iron_fist,
                "65",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "tv",
                null));

        tvShowsEntities.add(new TVShowsEntity(
                "t8",
                "Naruto Shippuden",
                "2007",
                "02/15/2007",
                "Animation, Comedy, Drama",
                "25m",
                R.drawable.poster_naruto_shipudden,
                "87",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "tv",
                null));

        tvShowsEntities.add(new TVShowsEntity(
                "t9",
                "NCIS",
                "2003",
                "09/23/2003",
                "Action & Adventure, Crime, Drama",
                "45m",
                R.drawable.poster_ncis,
                "71",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "tv",
                null));

        tvShowsEntities.add(new TVShowsEntity(
                "t10",
                "Riverdale",
                "2017",
                "01/26/2017",
                "Drama, Mystery",
                "45m",
                R.drawable.poster_riverdale,
                "86",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "tv",
                null));

        tvShowsEntities.add(new TVShowsEntity(
                "t11",
                "The Umbrella Academy",
                "2019",
                "02/15/2019",
                " Action & Adventure, Sci-Fi & Fantasy, Comedy, Drama",
                "55m",
                R.drawable.poster_the_umbrella,
                "87",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "tv",
                null));

        return tvShowsEntities;
    }

    public static List<MoviesResponse> generateRemoteMovies() {
        ArrayList<MoviesResponse> moviesResponses = new ArrayList<>();

        moviesResponses.add(new MoviesResponse(
                "m1",
                "Alita: Battle Angel",
                "2019",
                "02/14/2019",
                "Action, Science Fiction, Adventure",
                "2h 2m",
                R.drawable.poster_alita,
                "71",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "movie"));

        moviesResponses.add(new MoviesResponse(
                "m2",
                "Aquaman",
                "2018",
                "12/21/2018",
                "Action, Adventure, Fantasy",
                "2h 24m",
                R.drawable.poster_aquaman,
                "69",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "movie"));

        moviesResponses.add(new MoviesResponse(
                "m3",
                "A Star Is Born",
                "2018",
                "10/05/2018",
                "Drama, Romance, Music",
                "2h 16m",
                R.drawable.poster_a_start_is_born,
                "75",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "movie"));

        moviesResponses.add(new MoviesResponse(
                "m4",
                "Bohemian Rhapsody",
                "2018",
                "11/02/2018",
                "Drama, Music",
                "2h 15m",
                R.drawable.poster_bohemian,
                "80",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "movie"));

        moviesResponses.add(new MoviesResponse(
                "m5",
                "Cold Pursuit",
                "2019",
                "02/08/2019",
                "Action, Crime, Thriller",
                "1h 59m",
                R.drawable.poster_cold_persuit,
                "56",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "movie"));

        moviesResponses.add(new MoviesResponse(
                "m6",
                "Creed II",
                "2018",
                "11/21/2018",
                "Drama",
                "2h 10m",
                R.drawable.poster_creed,
                "69",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "movie"));

        moviesResponses.add(new MoviesResponse(
                "m7",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "2018",
                "11/16/2018",
                "Adventure, Fantasy, Drama",
                "2h 14m",
                R.drawable.poster_crimes,
                "69",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "movie"));

        moviesResponses.add(new MoviesResponse(
                "m8",
                "Glass",
                "2019",
                "01/18/2019",
                "Thriller, Drama, Science Fiction",
                "2h 9m",
                R.drawable.poster_glass,
                "66",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "movie"));

        moviesResponses.add(new MoviesResponse(
                "m9",
                "How to Train Your Dragon: The Hidden World",
                "2019",
                "02/22/2019",
                "Animation, Family, Adventure",
                "1h 44m",
                R.drawable.poster_how_to_train,
                "78",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "movie"));

        moviesResponses.add(new MoviesResponse(
                "m10",
                "Avengers: Infinity War",
                "2018",
                "04/27/2018",
                "Drama",
                "2h 29m",
                R.drawable.poster_infinity_war,
                "83",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "movie"));

        moviesResponses.add(new MoviesResponse(
                "m11",
                "Spider-Man: Into the Spider-Verse",
                "2018",
                "12/14/2018",
                "Action, Adventure, Animation, Science Fiction, Comedy",
                "1h 57m",
                R.drawable.poster_spiderman,
                "84",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "movie"));

        return moviesResponses;
    }

    public static List<TvShowsResponse> generateRemoteTVShows() {
        ArrayList<TvShowsResponse> tvShowsResponses = new ArrayList<>();

        tvShowsResponses.add(new TvShowsResponse(
                "t1",
                "Arrow",
                "2012",
                "10/10/2012",
                "Crime, Drama, Mystery, Action & Adventure",
                "42m",
                R.drawable.poster_arrow,
                "65",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "tv"));

        tvShowsResponses.add(new TvShowsResponse(
                "t2",
                "Dragon Ball",
                "1986",
                "02/26/1986",
                "Comedy, Sci-Fi & Fantasy, Animation, Action & Adventure",
                "25m",
                R.drawable.poster_dragon_ball,
                "80",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "tv"));

        tvShowsResponses.add(new TvShowsResponse(
                "t3",
                "The Flash",
                "2014",
                "10/07/2014",
                "Drama, Sci-Fi & Fantasy",
                "44m",
                R.drawable.poster_flash,
                "76",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "tv"));

        tvShowsResponses.add(new TvShowsResponse(
                "t4",
                "Gotham",
                "2014",
                "09/22/2014",
                "Drama, Fantasy, Crime",
                "43m",
                R.drawable.poster_gotham,
                "74",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "tv"));

        tvShowsResponses.add(new TvShowsResponse(
                "t5",
                "Grey's Anatomy",
                "2005",
                "03/27/2005",
                "Drama",
                "43m",
                R.drawable.poster_grey_anatomy,
                "81",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "tv"));

        tvShowsResponses.add(new TvShowsResponse(
                "t6",
                "Hanna",
                "2019",
                "03/28/2019",
                "Action & Adventure, Drama",
                "50m",
                R.drawable.poster_hanna,
                "74",
                "his thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "tv"));

        tvShowsResponses.add(new TvShowsResponse(
                "t7",
                "Marvel's Iron Fist",
                "2017",
                "03/17/2017",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "55m",
                R.drawable.poster_iron_fist,
                "65",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "tv"));

        tvShowsResponses.add(new TvShowsResponse(
                "t8",
                "Naruto Shippuden",
                "2007",
                "02/15/2007",
                "Animation, Comedy, Drama",
                "25m",
                R.drawable.poster_naruto_shipudden,
                "87",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "tv"));

        tvShowsResponses.add(new TvShowsResponse(
                "t9",
                "NCIS",
                "2003",
                "09/23/2003",
                "Action & Adventure, Crime, Drama",
                "45m",
                R.drawable.poster_ncis,
                "71",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "tv"));

        tvShowsResponses.add(new TvShowsResponse(
                "t10",
                "Riverdale",
                "2017",
                "01/26/2017",
                "Drama, Mystery",
                "45m",
                R.drawable.poster_riverdale,
                "86",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "tv"));

        tvShowsResponses.add(new TvShowsResponse(
                "t11",
                "The Umbrella Academy",
                "2019",
                "02/15/2019",
                " Action & Adventure, Sci-Fi & Fantasy, Comedy, Drama",
                "55m",
                R.drawable.poster_the_umbrella,
                "87",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "tv"));

        return tvShowsResponses;
    }
}
