/**
 * 
 * Vector.java
 * 
 * Provides a Vector object and performs operations on vectors.
 * 
 */

package scientific;

public class Vector {
  
  private double[] values;
  private int numberOfDimensions;

  public Vector(double params[])
  {
    this.values = params;
    this.numberOfDimensions = params.length;
  }


  // copy()
  public void copy(Vector that)
  {
    this.values = that.values;
    this.numberOfDimensions = that.numberOfDimensions;
  }

  // cross(Vector that)
  public void cross(Vector that)
  {
    //where crossProduct = this X that
    if(that.numberOfDimensions<=3 && this.numberOfDimensions<=3)
    {
      if(this.numberOfDimensions==that.numberOfDimensions && this.numberOfDimensions<=3)
      {
        this.values[0] = (this.values[1]*that.values[2]) - (this.values[2]*that.values[1]);
        this.values[1] = (this.values[0]*that.values[2]) - (this.values[2]*that.values[0]);
        this.values[2] = (this.values[0]*that.values[1]) - (this.values[1]*that.values[0]);
      }
    }
    else
    {
      ArithmeticException e = new ArithmeticException("n-dimensional cross product not yet implemented");
      throw e;
    }
  }
  // equals(Vector that, Comparator<E> comp)

  // equalsNC "non-comparator" function
  public boolean equalsNC(Vector that)
  {
    if(that.numberOfDimensions==this.numberOfDimensions)
    {
      boolean equalityHolds = true;
      for(int i=0; i<that.numberOfDimensions; i++)
      {
        if(this.values[i]!=that.values[i])
        {
          equalityHolds = false;
          break;
        }
      }  
      return equalityHolds;
    }
    else
    {
      return false;
    }
  }
  // getDimension()
  public int getDimension()
  {
    return this.numberOfDimensions;
  }
  // hashCode()

  // minus(Vector that)
  public void minus(Vector that)
  {
    //where resultant = this - that
    for(int i=0; i<that.numberOfDimensions; i++)
    {
      this.values[i] -= that.values[i];
    }
  }
  // plus(Vector that) 
  public void plus(Vector that)
  {
    //where resultant = this - that
    for(int i=0; i<that.numberOfDimensions; i++)
    {
      this.values[i] += that.values[i];
    }
  } 
  // opposite()
  public Vector opposite()
  {
    Vector oppositeVector = new Vector(this.values);
    for(int i=0; i<numberOfDimensions; i++)
    {
      oppositeVector.values[i] = -this.values[i];
    }
    return oppositeVector;
  }
  // scale(F k)
  public void scale(int k)
  {
    for(int i=0; i<numberOfDimensions; i++)
    {
      this.values[i]*=k;
    }
  }

  // times(Vector that)
  public long dotProduct(Vector that)
  {
    //where resultant = this.that
    long ret = 0;
    if(this.numberOfDimensions==that.numberOfDimensions)
    {
      for(int i=0; i<this.numberOfDimensions; i++)
      {
        ret += this.values[i]*that.values[i];
      }
      return ret;
    }
    else
    {
      ArithmeticException e = new ArithmeticException("Dimensions do not match: "+this.numberOfDimensions+" and "+that.numberOfDimensions);
      throw e;
    }
  }

  // toString()
  public String toString()
  {
    String ret = "";
    for(int i=0; i<numberOfDimensions; i++)
    {
      ret += this.values[i] + ", ";
    }   
    return ret;
  }
  // toText() 
  public String toText()
  {
    String ret = "";
    if(this.numberOfDimensions<=3)
    {
      if(this.values[0]!=0)
      {
        ret += this.values[0] + "i+";
      }
      if(this.values[1]!=0)
      {
        ret += this.values[1] + "j+";
      }
      if(this.values[2]!=0)
      {
        ret += this.values[2] + "k";
      }
    }
    else
    {
      for(int i=0; i<numberOfDimensions; i++)
      {
        if(this.values[i]!=0)
        {
          ret += this.values[i]+"a_"+(i+1)+"+";
        }
      }
    }
    if(ret.charAt(ret.length()-1) == '+')
    {
      ret = ret.substring(0,ret.length()-1);
    }
    return ret;
  }
}
