public class Main {
    public static void main(String[] args) {
        Season season1 = new Season();
        season1.addEpisode(new Episode("Breaking Bad S1E1: Pilot", 58 * 60));
        season1.addEpisode(new Episode("Breaking Bad S1E2: Cat's in the Bag...", 48 * 60));
        season1.addEpisode(new Episode("Breaking Bad S1E3: ...And the Bag's in the River", 48 * 60));

        Season season2 = new Season();
        season2.addEpisode(new Episode("Stranger Things S1E1: The Vanishing of Will Byers", 47 * 60));
        season2.addEpisode(new Episode("Stranger Things S1E2: The Weirdo on Maple Street", 55 * 60));

        System.out.println("Normal Order:");
        for (Episode e : season1) {
            System.out.println(e.getTitle());
        }

        System.out.println("\nReverse Order:");
        EpisodeIterator reverse = season1.reverseIterator();
        while (reverse.hasNext()) {
            System.out.println(reverse.next().getTitle());
        }

        System.out.println("\nShuffled Order:");
        EpisodeIterator shuffle = season1.shuffleIterator();
        while (shuffle.hasNext()) {
            System.out.println(shuffle.next().getTitle());
        }

        Series series = new Series();
        series.addSeason(season1);
        series.addSeason(season2);

        System.out.println("\nBinge Watching:");
        EpisodeIterator binge = series.bingeIterator();
        while (binge.hasNext()) {
            System.out.println(binge.next().getTitle());
        }
    }
}
