package lab2;

import java.util.ArrayList;
import java.util.List;

public class Algorithms {
    private int maxCapacity = 100;
    private List<Integer> containers;
    private int complexity = 0;
    public void nfa(Integer[] cargo, int sortComplexity){
        int containerFullness = 0;
        int containersQuantity = 1;
        complexity = 0;
        for(int i = 0; i < cargo.length; i++){
            if(containerFullness + cargo[i] <= maxCapacity ){
                containerFullness += cargo[i];
            } else {
                containersQuantity++;
                containerFullness = cargo[i];
            }
            complexity ++;
        }
        complexity+=sortComplexity;
        System.out.println("NFA: Complexity: "+complexity+" Containers: "+containersQuantity);
    }

    private boolean checkPreviousContainers(int cargo){
        boolean containerFound = false;
        for(int i = 0; i < containers.size(); i++){
            if(containers.get(i)+cargo <= maxCapacity){
                int c = containers.get(i);
                c += cargo;
                containers.set(i,c);
                containerFound = true;
                break;
            }
            complexity++;
        }
        return containerFound;
    }
    public void ffa(Integer[] cargo, int sortComplexity){
        containers = new ArrayList<>();
        containers.add(0);
        complexity = 0;
        int currentContainer = 0;
        for(int i = 0; i < cargo.length; i++){
            if(containers.get(currentContainer)+cargo[i] <= maxCapacity){
                int c = containers.get(currentContainer);
                c += cargo[i];
                containers.set(currentContainer,c);
            } else {
                if(!checkPreviousContainers(cargo[i])){
                    containers.add(cargo[i]);
                    currentContainer++;
                }
            }
            complexity++;
        }
        complexity+=sortComplexity;
        System.out.println("FFA: Complexity: "+complexity+" Containers: "+containers.size());
    }
    private int findContainerWithMaxCapacity(){
        int containerWithMaxCapacityIndex = -1;
        int capacity = 0;
        for(int i = 0; i < containers.size(); i++){
            if(maxCapacity-containers.get(i) > capacity){
                capacity = maxCapacity-containers.get(i);
                containerWithMaxCapacityIndex = i;
            }
            complexity++;
        }
        return containerWithMaxCapacityIndex;
    }
    public void wfa(Integer[] cargo, int sortComplexity){
        containers = new ArrayList<>();
        containers.add(0);
        complexity = 0;
        int currentContainer = 0;
        for(int i = 0; i < cargo.length; i++){
            if(containers.get(currentContainer)+cargo[i] <= maxCapacity){
                int c = containers.get(currentContainer);
                c += cargo[i];
                containers.set(currentContainer,c);
            } else {
                int containerWithMaxCapacityIndex = findContainerWithMaxCapacity();
                if(containerWithMaxCapacityIndex != -1){
                    if(containers.get(containerWithMaxCapacityIndex)+cargo[i] <= maxCapacity){
                        int c = containers.get(containerWithMaxCapacityIndex);
                        c += cargo[i];
                        containers.set(containerWithMaxCapacityIndex,c);
                    }
                    else{
                        containers.add(cargo[i]);
                        currentContainer++;
                    }
                }
            }
            complexity++;
        }
        complexity+=sortComplexity;
        System.out.println("WFA: Complexity: "+complexity+" Containers: "+containers.size());
    }

    private int findContainerWithMinCapacityThatFit(int cargo){
        int containerWithMinCapacityIndex = -1;
        int capacity = maxCapacity;
        for(int i = 0; i < containers.size(); i++){
            if((maxCapacity-containers.get(i) < capacity) && (containers.get(i) + cargo <= maxCapacity)){
                capacity = maxCapacity-containers.get(i);
                containerWithMinCapacityIndex = i;
            }
            complexity++;
        }
        return containerWithMinCapacityIndex;
    }
    public void bfa(Integer[] cargo, int sortComplexity){
        containers = new ArrayList<>();
        containers.add(0);
        complexity = 0;
        int currentContainer = 0;
        for(int i = 0; i < cargo.length; i++) {
            if (containers.get(currentContainer) + cargo[i] <= maxCapacity) {
                int c = containers.get(currentContainer);
                c += cargo[i];
                containers.set(currentContainer, c);
            } else {
                int containerWithMinCapacityIndex = findContainerWithMinCapacityThatFit(cargo[i]);
                if(containerWithMinCapacityIndex != -1){
                    int c = containers.get(containerWithMinCapacityIndex);
                    c += cargo[i];
                    containers.set(containerWithMinCapacityIndex, c);
                } else {
                    containers.add(cargo[i]);
                    currentContainer++;
                }
            }
            complexity++;
        }
        complexity+=sortComplexity;
        System.out.println("BFA: Complexity: "+complexity+" Containers: "+containers.size());
    }

}
