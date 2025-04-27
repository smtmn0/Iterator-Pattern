import java.util.*;

public class Series {
    private List<Season> seasons = new ArrayList<>();

    public void addSeason(Season s) {
        seasons.add(s);
    }

    public EpisodeIterator bingeIterator() {
        return new BingeIterator(seasons);
    }

    private static class BingeIterator implements EpisodeIterator {
        private Iterator<Season> seasonIter;
        private EpisodeIterator episodeIter;

        public BingeIterator(List<Season> seasons) {
            seasonIter = seasons.iterator();
            episodeIter = new EmptyEpisodeIterator();
        }

        public boolean hasNext() {
            while (!episodeIter.hasNext() && seasonIter.hasNext()) {
                Season season = seasonIter.next();
                episodeIter = seasonIterator(season);
            }
            return episodeIter.hasNext();
        }

        public Episode next() {
            if (!hasNext()) throw new NoSuchElementException();
            return episodeIter.next();
        }

        private static EpisodeIterator seasonIterator(Season season) {
            return season.new SeasonIterator();
        }

        private static class EmptyEpisodeIterator implements EpisodeIterator {
            public boolean hasNext() { return false; }
            public Episode next() { throw new NoSuchElementException(); }
        }
    }
}


