func main() {
	var x int
	var z int = 0
	x = 084
	
	for x > 0 {
		x = x / 2
		z += x
	}
	
	write(z)
	
}