func main() {
	var x int
	var z int
	x = 84
	z = 0
	for x > 0 {
		x = x / 2
		z = z + x
	}
	
	write(z)
	
}
