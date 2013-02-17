package src.urn_TestCOPServiceDef_1_0.Messages;

import framework.messages.Message;
import framework.JausUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.BitSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportLocalPathSegment extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x4410;
	
	public static class  AppHeader
	{
		public static class  HeaderRec
		{
		
			protected AppHeader m_parent;
			protected int m_MessageID;
		
			public void setParent(AppHeader parent)
			{
				m_parent = parent;
			}
			
			public void setParentPresenceVector()
			{
				if(m_parent != null )
				{
					m_parent.setParentPresenceVector();
				}
			}
			
			public int getMessageID()
			{
				return m_MessageID;
			}
			
			public void setMessageID(int value)
			{
				m_MessageID = value;
				setParentPresenceVector();
			}
			
			/**
			 * Returns the number of bytes the used data members of the class occupies
			 * in the buffer. This is not the number of bytes the data type occupies in 
			 * Java, but the bytes expected on the wire.
			 * 
			 * @return
			 */
			public long getSize()
			{
				long size = 0;
				
				size += JausUtils.getNumBytes("short");
				
				return size;
			}
			
			public void encode(ByteBuffer bytes, int pos)
			{
				
				if (bytes.array() == null)
				{
					return;
				}
				
				if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
				{
					bytes.order(ByteOrder.LITTLE_ENDIAN);
				}
				
				bytes.putShort(pos, (short) m_MessageID);
				pos += JausUtils.getNumBytes("short");
			}
			
			public void decode(ByteBuffer bytes, int pos)
			{
				
				if (bytes.array() == null)
				{
					return;
				}
				if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
				{
					bytes.order(ByteOrder.LITTLE_ENDIAN);
				}
				
				m_MessageID = bytes.getShort(pos) & 0xffff;
				pos += JausUtils.getNumBytes("short");
			}
			
			public ReportLocalPathSegment.AppHeader.HeaderRec assign(HeaderRec value)
			{
				m_MessageID = value.m_MessageID;
				
				return this;
			}
			
			public boolean isEqual(HeaderRec value)
			{
				if (m_MessageID != value.getMessageID())
				{
					return false;
				}
				
				return true;
			}
			
			public boolean notEquals(HeaderRec value)
			{
				return !this.isEqual(value);
			}
			
			public HeaderRec()
			{
				m_parent = null;
				m_MessageID = 0x4410;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x4410;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportLocalPathSegment.AppHeader.HeaderRec getHeaderRec()
		{
			return m_HeaderRec;
		}
		
		public void setHeaderRec(HeaderRec value)
		{
			m_HeaderRec = value;
			setParentPresenceVector();
		}
		
		public void setParentPresenceVector()
		{
			// Nothing needed here, placeholder function
		}
		
		/**
		 * Returns the number of bytes the used data members of the class occupies
		 * in the buffer. This is not the number of bytes the data type occupies in 
		 * Java, but the bytes expected on the wire.
		 * 
		 * @return
		 */
		public long getSize()
		{
			long size = 0;
			
			size += m_HeaderRec.getSize();
			
			return size;
		}
		
		public void encode(ByteBuffer bytes, int pos)
		{
			
			if (bytes.array() == null)
			{
				return;
			}
			
			if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
			{
				bytes.order(ByteOrder.LITTLE_ENDIAN);
			}
			
			m_HeaderRec.encode(bytes, pos);
			pos += m_HeaderRec.getSize();
		}
		
		public void decode(ByteBuffer bytes, int pos)
		{
			
			if (bytes.array() == null)
			{
				return;
			}
			if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
			{
				bytes.order(ByteOrder.LITTLE_ENDIAN);
			}
			
			m_HeaderRec.decode(bytes, pos);
			pos += m_HeaderRec.getSize();
		}
		
		public ReportLocalPathSegment.AppHeader assign(AppHeader value)
		{
			m_HeaderRec = value.m_HeaderRec;
			m_HeaderRec.setParent(this);
			
			return this;
		}
		
		public boolean isEqual(AppHeader value)
		{
			if (!m_HeaderRec.isEqual(value.getHeaderRec()))
			{
				return false;
			}
			return true;
		}
		
		public boolean notEquals(AppHeader value)
		{
			return !this.isEqual(value);
		}
		
		public AppHeader()
		{
			m_HeaderRec = new HeaderRec();
			m_HeaderRec.setParent(this);
		}
		
		public AppHeader(AppHeader value)
		{
			/// Initiliaze the protected variables
			m_HeaderRec = new HeaderRec();
			m_HeaderRec.setParent(this);
			
			/// Copy the values
			m_HeaderRec = value.m_HeaderRec;
			m_HeaderRec.setParent(this);
		}
		
		public void finalize()
		{
		}
		
	}
	public static class  Body
	{
		public static class  LocalPathSegmentRec
		{
		
			protected Body m_parent;
			protected BitSet m_PresenceVector;
			protected short m_PresenceVectorTemp;
			protected long m_P1_X;
			protected long m_P1_Y;
			protected long m_P1_Z;
			protected long m_P2_X;
			protected long m_P2_Y;
			protected long m_P2_Z;
			protected int m_WeightingFactor;
			protected long m_PathTolerance;
		
			public void setParent(Body parent)
			{
				m_parent = parent;
			}
			
			public void setParentPresenceVector()
			{
				if(m_parent != null )
				{
					m_parent.setParentPresenceVector();
				}
			}
			
			public short getPresenceVector()
			{
				return m_PresenceVectorTemp;
			}
			
			protected void setPresenceVector(int index)
			{
				
				m_PresenceVector.set(index);
				m_PresenceVectorTemp = (short) JausUtils.getPVInt(m_PresenceVector);
			}
			
			public boolean checkPresenceVector(int index)
			{
				
				return m_PresenceVector.get(index);
			}
			
			public double getP1_X()
			{
				double value;
				
				double scaleFactor = ( 100000 - -100000 ) / 4.294967295E9;
				double bias = -100000;
				
				value = m_P1_X * scaleFactor + bias;
				
				return value;
			}
			
			public void setP1_X(double value)
			{
				if ((value >= -100000) && (value <= 100000))
				{
					double scaleFactor = ( 100000 - -100000 ) / 4.294967295E9;
					double bias = -100000;
					
					m_P1_X= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getP1_Y()
			{
				double value;
				
				double scaleFactor = ( 100000 - -100000 ) / 4.294967295E9;
				double bias = -100000;
				
				value = m_P1_Y * scaleFactor + bias;
				
				return value;
			}
			
			public void setP1_Y(double value)
			{
				if ((value >= -100000) && (value <= 100000))
				{
					double scaleFactor = ( 100000 - -100000 ) / 4.294967295E9;
					double bias = -100000;
					
					m_P1_Y= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isP1_ZValid()
			{
				if (checkPresenceVector(0))
				{
					return true;
				}
				return false;
			}
			
			public double getP1_Z()
			{
				double value;
				
				double scaleFactor = ( 35000 - -10000 ) / 4.294967295E9;
				double bias = -10000;
				
				value = m_P1_Z * scaleFactor + bias;
				
				return value;
			}
			
			public void setP1_Z(double value)
			{
				if ((value >= -10000) && (value <= 35000))
				{
					double scaleFactor = ( 35000 - -10000 ) / 4.294967295E9;
					double bias = -10000;
					
					m_P1_Z= (long)((value - bias) / scaleFactor);
					setPresenceVector(0);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getP2_X()
			{
				double value;
				
				double scaleFactor = ( 100000 - -100000 ) / 4.294967295E9;
				double bias = -100000;
				
				value = m_P2_X * scaleFactor + bias;
				
				return value;
			}
			
			public void setP2_X(double value)
			{
				if ((value >= -100000) && (value <= 100000))
				{
					double scaleFactor = ( 100000 - -100000 ) / 4.294967295E9;
					double bias = -100000;
					
					m_P2_X= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getP2_Y()
			{
				double value;
				
				double scaleFactor = ( 100000 - -100000 ) / 4.294967295E9;
				double bias = -100000;
				
				value = m_P2_Y * scaleFactor + bias;
				
				return value;
			}
			
			public void setP2_Y(double value)
			{
				if ((value >= -100000) && (value <= 100000))
				{
					double scaleFactor = ( 100000 - -100000 ) / 4.294967295E9;
					double bias = -100000;
					
					m_P2_Y= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isP2_ZValid()
			{
				if (checkPresenceVector(1))
				{
					return true;
				}
				return false;
			}
			
			public double getP2_Z()
			{
				double value;
				
				double scaleFactor = ( 35000 - -10000 ) / 4.294967295E9;
				double bias = -10000;
				
				value = m_P2_Z * scaleFactor + bias;
				
				return value;
			}
			
			public void setP2_Z(double value)
			{
				if ((value >= -10000) && (value <= 35000))
				{
					double scaleFactor = ( 35000 - -10000 ) / 4.294967295E9;
					double bias = -10000;
					
					m_P2_Z= (long)((value - bias) / scaleFactor);
					setPresenceVector(1);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getWeightingFactor()
			{
				double value;
				
				double scaleFactor = ( 500 - 0 ) / 65535.0;
				double bias = 0;
				
				value = m_WeightingFactor * scaleFactor + bias;
				
				return value;
			}
			
			public void setWeightingFactor(double value)
			{
				if ((value >= 0) && (value <= 500))
				{
					double scaleFactor = ( 500 - 0 ) / 65535.0;
					double bias = 0;
					
					m_WeightingFactor= (int)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isPathToleranceValid()
			{
				if (checkPresenceVector(2))
				{
					return true;
				}
				return false;
			}
			
			public double getPathTolerance()
			{
				double value;
				
				double scaleFactor = ( 100000 - 0 ) / 4.294967295E9;
				double bias = 0;
				
				value = m_PathTolerance * scaleFactor + bias;
				
				return value;
			}
			
			public void setPathTolerance(double value)
			{
				if ((value >= 0) && (value <= 100000))
				{
					double scaleFactor = ( 100000 - 0 ) / 4.294967295E9;
					double bias = 0;
					
					m_PathTolerance= (long)((value - bias) / scaleFactor);
					setPresenceVector(2);
					setParentPresenceVector();
				}
				return;
			}
			
			/**
			 * Returns the number of bytes the used data members of the class occupies
			 * in the buffer. This is not the number of bytes the data type occupies in 
			 * Java, but the bytes expected on the wire.
			 * 
			 * @return
			 */
			public long getSize()
			{
				long size = 0;
				
				size += JausUtils.getNumBytes("byte");
				size += JausUtils.getNumBytes("int");
				size += JausUtils.getNumBytes("int");
				if (checkPresenceVector(0))
				{
					size += JausUtils.getNumBytes("int");
				}
				size += JausUtils.getNumBytes("int");
				size += JausUtils.getNumBytes("int");
				if (checkPresenceVector(1))
				{
					size += JausUtils.getNumBytes("int");
				}
				size += JausUtils.getNumBytes("short");
				if (checkPresenceVector(2))
				{
					size += JausUtils.getNumBytes("int");
				}
				
				return size;
			}
			
			public void encode(ByteBuffer bytes, int pos)
			{
				
				if (bytes.array() == null)
				{
					return;
				}
				
				if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
				{
					bytes.order(ByteOrder.LITTLE_ENDIAN);
				}
				
				try
				{
					short m_PresenceVectorTemp = (short) JausUtils.getPVInt(m_PresenceVector);
				bytes.put(pos, (byte) m_PresenceVectorTemp);
				pos += JausUtils.getNumBytes("byte");
				}
				catch(Exception e)
				{
					logger.log(Level.SEVERE, null, e);
				}
				bytes.putInt(pos, (int) m_P1_X);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_P1_Y);
				pos += JausUtils.getNumBytes("int");
				if (checkPresenceVector(0))
				{
					bytes.putInt(pos, (int) m_P1_Z);
					pos += JausUtils.getNumBytes("int");
				}
				bytes.putInt(pos, (int) m_P2_X);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_P2_Y);
				pos += JausUtils.getNumBytes("int");
				if (checkPresenceVector(1))
				{
					bytes.putInt(pos, (int) m_P2_Z);
					pos += JausUtils.getNumBytes("int");
				}
				bytes.putShort(pos, (short) m_WeightingFactor);
				pos += JausUtils.getNumBytes("short");
				if (checkPresenceVector(2))
				{
					bytes.putInt(pos, (int) m_PathTolerance);
					pos += JausUtils.getNumBytes("int");
				}
			}
			
			public void decode(ByteBuffer bytes, int pos)
			{
				
				if (bytes.array() == null)
				{
					return;
				}
				if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
				{
					bytes.order(ByteOrder.LITTLE_ENDIAN);
				}
				
				try
				{
					short m_PresenceVectorTemp = 0;
				m_PresenceVectorTemp = (short) (bytes.get(pos) & 0xff);
				pos += JausUtils.getNumBytes("byte");
				m_PresenceVector = JausUtils.setPV(m_PresenceVectorTemp);
				}
				catch(Exception e)
				{
					logger.log(Level.SEVERE, null, e);
				}
				m_P1_X = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_P1_Y = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				if (checkPresenceVector(0))
				{
					m_P1_Z = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
				m_P2_X = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_P2_Y = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				if (checkPresenceVector(1))
				{
					m_P2_Z = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
				m_WeightingFactor = bytes.getShort(pos) & 0xffff;
				pos += JausUtils.getNumBytes("short");
				if (checkPresenceVector(2))
				{
					m_PathTolerance = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
			}
			
			public ReportLocalPathSegment.Body.LocalPathSegmentRec assign(LocalPathSegmentRec value)
			{
				m_PresenceVector = value.m_PresenceVector;
				m_P1_X = value.m_P1_X;
				m_P1_Y = value.m_P1_Y;
				m_P1_Z = value.m_P1_Z;
				m_P2_X = value.m_P2_X;
				m_P2_Y = value.m_P2_Y;
				m_P2_Z = value.m_P2_Z;
				m_WeightingFactor = value.m_WeightingFactor;
				m_PathTolerance = value.m_PathTolerance;
				
				return this;
			}
			
			public boolean isEqual(LocalPathSegmentRec value)
			{
				if (!m_PresenceVector.equals(value.m_PresenceVector))
				{
					return false;
				}
				if (m_P1_X != value.getP1_X())
				{
					return false;
				}
				if (m_P1_Y != value.getP1_Y())
				{
					return false;
				}
				if (m_P1_Z != value.getP1_Z())
				{
					return false;
				}
				if (m_P2_X != value.getP2_X())
				{
					return false;
				}
				if (m_P2_Y != value.getP2_Y())
				{
					return false;
				}
				if (m_P2_Z != value.getP2_Z())
				{
					return false;
				}
				if (m_WeightingFactor != value.getWeightingFactor())
				{
					return false;
				}
				if (m_PathTolerance != value.getPathTolerance())
				{
					return false;
				}
				
				return true;
			}
			
			public boolean notEquals(LocalPathSegmentRec value)
			{
				return !this.isEqual(value);
			}
			
			public LocalPathSegmentRec()
			{
				m_parent = null;
				m_PresenceVector = new BitSet();
				m_PresenceVectorTemp = 0;
				m_P1_X = 0;
				m_P1_Y = 0;
				m_P1_Z = 0;
				m_P2_X = 0;
				m_P2_Y = 0;
				m_P2_Z = 0;
				m_WeightingFactor = 0;
				m_PathTolerance = 0;
			}
			
			public LocalPathSegmentRec(LocalPathSegmentRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_PresenceVector = new BitSet();
				m_PresenceVectorTemp = 0;
				m_P1_X = 0;
				m_P1_Y = 0;
				m_P1_Z = 0;
				m_P2_X = 0;
				m_P2_Y = 0;
				m_P2_Z = 0;
				m_WeightingFactor = 0;
				m_PathTolerance = 0;
				
				/// Copy the values
				m_PresenceVector = value.m_PresenceVector;
				m_P1_X = value.m_P1_X;
				m_P1_Y = value.m_P1_Y;
				m_P1_Z = value.m_P1_Z;
				m_P2_X = value.m_P2_X;
				m_P2_Y = value.m_P2_Y;
				m_P2_Z = value.m_P2_Z;
				m_WeightingFactor = value.m_WeightingFactor;
				m_PathTolerance = value.m_PathTolerance;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected LocalPathSegmentRec m_LocalPathSegmentRec;
	
		public ReportLocalPathSegment.Body.LocalPathSegmentRec getLocalPathSegmentRec()
		{
			return m_LocalPathSegmentRec;
		}
		
		public void setLocalPathSegmentRec(LocalPathSegmentRec value)
		{
			m_LocalPathSegmentRec = value;
			setParentPresenceVector();
		}
		
		public void setParentPresenceVector()
		{
			// Nothing needed here, placeholder function
		}
		
		/**
		 * Returns the number of bytes the used data members of the class occupies
		 * in the buffer. This is not the number of bytes the data type occupies in 
		 * Java, but the bytes expected on the wire.
		 * 
		 * @return
		 */
		public long getSize()
		{
			long size = 0;
			
			size += m_LocalPathSegmentRec.getSize();
			
			return size;
		}
		
		public void encode(ByteBuffer bytes, int pos)
		{
			
			if (bytes.array() == null)
			{
				return;
			}
			
			if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
			{
				bytes.order(ByteOrder.LITTLE_ENDIAN);
			}
			
			m_LocalPathSegmentRec.encode(bytes, pos);
			pos += m_LocalPathSegmentRec.getSize();
		}
		
		public void decode(ByteBuffer bytes, int pos)
		{
			
			if (bytes.array() == null)
			{
				return;
			}
			if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
			{
				bytes.order(ByteOrder.LITTLE_ENDIAN);
			}
			
			m_LocalPathSegmentRec.decode(bytes, pos);
			pos += m_LocalPathSegmentRec.getSize();
		}
		
		public ReportLocalPathSegment.Body assign(Body value)
		{
			m_LocalPathSegmentRec = value.m_LocalPathSegmentRec;
			m_LocalPathSegmentRec.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_LocalPathSegmentRec.isEqual(value.getLocalPathSegmentRec()))
			{
				return false;
			}
			/// This code is currently not supported
			return true;
		}
		
		public boolean notEquals(Body value)
		{
			return !this.isEqual(value);
		}
		
		public Body()
		{
			m_LocalPathSegmentRec = new LocalPathSegmentRec();
			m_LocalPathSegmentRec.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_LocalPathSegmentRec = new LocalPathSegmentRec();
			m_LocalPathSegmentRec.setParent(this);
			
			/// Copy the values
			m_LocalPathSegmentRec = value.m_LocalPathSegmentRec;
			m_LocalPathSegmentRec.setParent(this);
			/// This code is currently not supported
		}
		
		public void finalize()
		{
		}
		
	}
	protected AppHeader m_AppHeader;
	protected Body m_Body;
	public long getID()
	{
	return ID;
 }
	public ReportLocalPathSegment.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public ReportLocalPathSegment.Body getBody()
	{
		return m_Body;
	}
	
	public int setBody(Body value)
	{
		m_Body = value;
		return 0;
	}
	
	/**
	 * Returns the number of bytes the used data members of the class occupies
	 * in the buffer. This is not the number of bytes the data type occupies in 
	 * Java, but the bytes expected on the wire.
	 * 
	 * @return
	 */
	public long getSize()
	{
		int size = 0;
		
		size += m_AppHeader.getSize();
		size += m_Body.getSize();
		
		return size;
	}
	
	public void encode(ByteBuffer bytes, int pos)
	{
		
		if (bytes.array() == null)
		{
			return;
		}
		if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
		{
			bytes.order(ByteOrder.LITTLE_ENDIAN);
		}
		
		m_AppHeader.encode(bytes, pos);
		pos += m_AppHeader.getSize();
		m_Body.encode(bytes, pos);
		pos += m_Body.getSize();
	}
	
	public void decode(ByteBuffer bytes, int pos)
	{
		
		if (bytes.array() == null)
		{
			return;
		}
		if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
		{
			bytes.order(ByteOrder.LITTLE_ENDIAN);
		}
		
		m_AppHeader.decode(bytes, pos);
		pos += m_AppHeader.getSize();
		m_Body.decode(bytes, pos);
		pos += m_Body.getSize();
	}
	
	public ReportLocalPathSegment setAs(ReportLocalPathSegment value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportLocalPathSegment value)
	{
		if (!m_AppHeader.isEqual(value.getAppHeader()))
		{
			return false;
		}
		if (!m_Body.isEqual(value.getBody()))
		{
			return false;
		}
		
		return true;
	}
	
	public boolean notEquals(ReportLocalPathSegment value)
	{
		return !isEqual(value);
	}
	
	public ReportLocalPathSegment()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportLocalPathSegment(ReportLocalPathSegment value)
	{
		/// Initiliaze the protected variables
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
		
		/// Copy the values
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
	}
	
}
