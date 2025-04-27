public class Main {
    public static void main(String[] args) {
        Season season = new Season();
        season.addEpisode(new Episode("Episode 1", 45));
        season.addEpisode(new Episode("Episode 2", 42));
        season.addEpisode(new Episode("Episode 3", 47));

        System.out.println("Normal Order:");
        for (Episode e : season) {
            System.out.println(e.getTitle());
        }

        System.out.println("\nReverse Order:");
        EpisodeIterator reverse = season.reverseIterator();
        while (reverse.hasNext()) {
            System.out.println(reverse.next().getTitle());
        }

        System.out.println("\nShuffled Order:");
        EpisodeIterator shuffle = season.shuffleIterator();
        while (shuffle.hasNext()) {
            System.out.println(shuffle.next().getTitle());
        }

        Series series = new Series();
        series.addSeason(season);
        Season season2 = new Season();
        season2.addEpisode(new Episode("Episode 4", 40));
        series.addSeason(season2);

        System.out.println("\nBinge Watching:");
        EpisodeIterator binge = series.bingeIterator();
        while (binge.hasNext()) {
            System.out.println(binge.next().getTitle());
        }
    }
}