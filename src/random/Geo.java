package random;

//import org.apache.commons.lang.builder.EqualsBuilder;
//import org.apache.commons.lang.builder.HashCodeBuilder;

public class Geo {
	public long latitude;
	public long longitude;
	
	public Geo(long latitude,long longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Geo))
			return false;
		if (obj == this)
			return true;
		Geo rhs = (Geo) obj;
		return (rhs.latitude==this.latitude && rhs.longitude==this.longitude);
			
		//Alternatively using EqualsBuilder from Apache Commons Lang 
//		return new EqualsBuilder().
//		 		append(this.latitude,rhs.latitude).
//		 		append(this.longitude,rhs.longitude).
//		 		isEquals();		 
	}
	
	@Override
	public int hashCode() {
//		return new HashCodeBuilder(17,31).
//				append(this.latitude).
//				append(this.longitude).
//				toHashCode();
		int hash = 7;
		hash = 17 * hash + Long.valueOf(this.latitude).hashCode();
		hash = 17 * hash + Long.valueOf(this.longitude).hashCode();
		return hash;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	   String NEW_LINE = System.getProperty("line.separator");
		sb.append(this.getClass().getName() + "Object {" + NEW_LINE);
		sb.append("Latitude: "+latitude + " } "); // + longitude
		return sb.toString();
	}
	
}
