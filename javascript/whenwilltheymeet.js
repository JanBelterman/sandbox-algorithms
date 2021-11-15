function whenWillTheyMeet(wallLength, pace1, pace2) {
    collectivePace = pace1 + pace2
    time = wallLength / collectivePace;
    console.log(`Painters will meet at ${(time * pace1).toFixed(2)} metres`)
    console.log(`Painters and it will take them ${(time * 60).toFixed(2)} minutes`)
}

calculateIntersectionPoint(10, 4, 2.5)