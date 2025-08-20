import java.util.Scanner;
class Alien 
{
    public static void Graph(String[] words, int k, int[][] graph) 
    {
        for (int i=0;i<words.length-1;i++) 
        {
            String w1=words[i];
            String w2=words[i + 1];

            int minLen=Math.min(w1.length(), w2.length());

            for (int j=0;j<minLen;j++) 
            {
                if (w1.charAt(j)!=w2.charAt(j)) 
                {
                    int u=w1.charAt(j)-'a';
                    int v=w2.charAt(j)-'a';
                    graph[u][v]=1;
                    break; 
                }
            }
        }
    }
    //for topological sorting using dfs-depth first search
    public static void dfs(int node, boolean[] visited, int[][] graph, StringBuilder result, int k) 
    {
        visited[node] = true;

        for (int v=0;v<k;v++) 
        {
            if (graph[node][v]==1&&!visited[v]) 
            {
                dfs(v, visited, graph, result, k);
            }
        }

        //insert after visiting all
        result.insert(0, (char) (node + 'a'));
    }

    public static String findOrder(String[] words, int k) 
    {
        int[][] graph=new int[k][k];
        Graph(words, k, graph);

        boolean[] visited=new boolean[k];
        StringBuilder result=new StringBuilder();

        for (int i=0;i<k;i++) 
        {
            if (!visited[i]) 
            {
                dfs(i, visited, graph, result, k);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of words: ");
        int n=sc.nextInt();
        sc.nextLine(); // to consume the newline

        String[] words=new String[n];
        System.out.println("Words:");
        for (int i=0;i<n;i++) 
        {
            words[i]=sc.nextLine();
        }

        System.out.print("Enter number of distinct characters (k): ");
        int k=sc.nextInt();

        String order=findOrder(words, k);
        System.out.println("A valid order of characters: " + order);
    }
}

