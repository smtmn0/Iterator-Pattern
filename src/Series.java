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
            episodeIter = Collections.emptyIterator();
        }

        public boolean hasNext() {
            while (!episodeIter.hasNext() && seasonIter.hasNext()) {
                episodeIter = seasonIter.next().iterator();
            }
            return episodeIter.hasNext();
        }

        public Episode next() {
            if (!hasNext()) throw new NoSuchElementException();
            return episodeIter.next();
        }
    }
}