import java.util.*;

public class Season implements Iterable<Episode> {
    private List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    @Override
    public EpisodeIterator iterator() {
        return new SeasonIterator();
    }

    public EpisodeIterator reverseIterator() {
        return new ReverseSeasonIterator();
    }

    public EpisodeIterator shuffleIterator() {
        return new ShuffleSeasonIterator();
    }

    private class SeasonIterator implements EpisodeIterator {
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
}