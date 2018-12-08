var x int
func main() {
	var x int = 0
	var z int = 0
	x = 084
	
	for x > 0 {
		x = x / 2
		z = x + z
	}
	
	write(z)
	
}