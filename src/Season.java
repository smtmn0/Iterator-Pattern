import java.util.*;

public class Season implements Iterable<Episode> {
    private List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    @Override
    public Iterator<Episode> iterator() {
        return new IteratorAdapter(new SeasonIterator());
    }

    public EpisodeIterator reverseIterator() {
        return new ReverseSeasonIterator();
    }

    public EpisodeIterator shuffleIterator() {
        return new ShuffleSeasonIterator();
    }

    public class SeasonIterator implements EpisodeIterator {
        private int index = 0;

        public boolean hasNext() {
            return index < episodes.size();
        }

        public Episode next() {
            return episodes.get(index++);
        }
    }

    private class ReverseSeasonIterator implements EpisodeIterator {
        private int index = episodes.size() - 1;

        public boolean hasNext() {
            return index >= 0;
        }

        public Episode next() {
            return episodes.get(index--);
        }
    }

    private class ShuffleSeasonIterator implements EpisodeIterator {
        private List<Episode> shuffled;
        private int index = 0;

        public ShuffleSeasonIterator() {
            shuffled = new ArrayList<>(episodes);
            Collections.shuffle(shuffled, new Random(42));
        }

        public boolean hasNext() {
            return index < shuffled.size();
        }

        public Episode next() {
            return shuffled.get(index++);
        }
    }

    private static class IteratorAdapter implements Iterator<Episode> {
        private EpisodeIterator episodeIterator;

        public IteratorAdapter(EpisodeIterator episodeIterator) {
            this.episodeIterator = episodeIterator;
        }

        public boolean hasNext() {
            return episodeIterator.hasNext();
        }

        public Episode next() {
            return episodeIterator.next();
        }
    }
}

