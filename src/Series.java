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
        private Iterator<Season> seasonIterator;
        private EpisodeIterator episodeIterator;

        public BingeIterator(List<Season> seasons) {
            seasonIterator = seasons.iterator();
            episodeIterator = new EmptyEpisodeIterator();
        }

        public boolean hasNext() {
            while (!episodeIterator.hasNext() && seasonIterator.hasNext()) {
                episodeIterator = seasonIterator.next().iterator();
            }
            return episodeIterator.hasNext();
        }

        public Episode next() {
            if (!hasNext()) throw new NoSuchElementException();
            return episodeIterator.next();
        }
    }

    private static class EmptyEpisodeIterator implements EpisodeIterator {
        public boolean hasNext() {
            return false;
        }

        public Episode next() {
            throw new NoSuchElementException();
        }
    }
}
