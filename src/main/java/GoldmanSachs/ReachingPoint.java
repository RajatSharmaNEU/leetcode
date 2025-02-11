package GoldmanSachs;

public class ReachingPoint {
    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty)
            if (tx < ty)
                ty %= tx;
            else
                tx %= ty;

        if (sx == tx && sy <= ty && (ty - sy) % sx == 0)
            return true;

        return sy == ty && sx <= tx && (tx - sx) % sy == 0;
    }

    public static void main(String[] args) {
        System.out.println(reachingPoints(1, 1, 3, 5));
        System.out.println(reachingPoints(2, 2, 10000000, 4));
    }
}
