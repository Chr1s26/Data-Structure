public class DSUDemo{

    public static int[] parent,rank,compMin;
    public static void main(String[] args) {
        init(6);
        union(1, 2);
        union(2, 3);
        union(4, 5);

        System.out.println(compMin[find(1)]);
        System.out.println(compMin[find(3)]);
        System.out.println(compMin[find(3)]);
    }

    public static void init(int n){
        parent = new int[n+1];
        rank = new int[n+1];
        compMin = new int[n+1];

        for(int i = 1; i <= n; i++){
            parent[i] = i;
            rank[i] = 0;
            compMin[i] = i;
        }
    }

    public static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return;

        if(rank[rootA] < rank[rootB]){
            parent[rootA] = rootB;
            compMin[rootB] = Math.min(compMin[rootB], compMin[rootA]);
        }else if(rank[rootA] > rank[rootB]){
            parent[rootB] = rootA;
            compMin[rootA] = Math.min(compMin[rootA], compMin[rootB]);
        }else{
            parent[rootB] = rootA;
            rank[rootA]++;
            compMin[rootA] = Math.min(compMin[rootA], compMin[rootB]);
        }
    }
}