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

public class ReportGlobalPathSegment extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x440f;
	
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
			
			public ReportGlobalPathSegment.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x440f;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x440f;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportGlobalPathSegment.AppHeader.HeaderRec getHeaderRec()
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
		
		public ReportGlobalPathSegment.AppHeader assign(AppHeader value)
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
		public static class  GlobalPathSegmentRec
		{
		
			protected Body m_parent;
			protected BitSet m_PresenceVector;
			protected short m_PresenceVectorTemp;
			protected long m_P1_Latitude;
			protected long m_P1_Longitude;
			protected long m_P1_Altitude;
			protected long m_P2_Latitude;
			protected long m_P2_Longitude;
			protected long m_P2_Altitude;
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
			
			public double getP1_Latitude()
			{
				double value;
				
				double scaleFactor = ( 90 - -90 ) / 4.294967295E9;
				double bias = -90;
				
				value = m_P1_Latitude * scaleFactor + bias;
				
				return value;
			}
			
			public void setP1_Latitude(double value)
			{
				if ((value >= -90) && (value <= 90))
				{
					double scaleFactor = ( 90 - -90 ) / 4.294967295E9;
					double bias = -90;
					
					m_P1_Latitude= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getP1_Longitude()
			{
				double value;
				
				double scaleFactor = ( 180 - -180 ) / 4.294967295E9;
				double bias = -180;
				
				value = m_P1_Longitude * scaleFactor + bias;
				
				return value;
			}
			
			public void setP1_Longitude(double value)
			{
				if ((value >= -180) && (value <= 180))
				{
					double scaleFactor = ( 180 - -180 ) / 4.294967295E9;
					double bias = -180;
					
					m_P1_Longitude= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isP1_AltitudeValid()
			{
				if (checkPresenceVector(0))
				{
					return true;
				}
				return false;
			}
			
			public double getP1_Altitude()
			{
				double value;
				
				double scaleFactor = ( 35000 - -10000 ) / 4.294967295E9;
				double bias = -10000;
				
				value = m_P1_Altitude * scaleFactor + bias;
				
				return value;
			}
			
			public void setP1_Altitude(double value)
			{
				if ((value >= -10000) && (value <= 35000))
				{
					double scaleFactor = ( 35000 - -10000 ) / 4.294967295E9;
					double bias = -10000;
					
					m_P1_Altitude= (long)((value - bias) / scaleFactor);
					setPresenceVector(0);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getP2_Latitude()
			{
				double value;
				
				double scaleFactor = ( 90 - -90 ) / 4.294967295E9;
				double bias = -90;
				
				value = m_P2_Latitude * scaleFactor + bias;
				
				return value;
			}
			
			public void setP2_Latitude(double value)
			{
				if ((value >= -90) && (value <= 90))
				{
					double scaleFactor = ( 90 - -90 ) / 4.294967295E9;
					double bias = -90;
					
					m_P2_Latitude= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getP2_Longitude()
			{
				double value;
				
				double scaleFactor = ( 180 - -180 ) / 4.294967295E9;
				double bias = -180;
				
				value = m_P2_Longitude * scaleFactor + bias;
				
				return value;
			}
			
			public void setP2_Longitude(double value)
			{
				if ((value >= -180) && (value <= 180))
				{
					double scaleFactor = ( 180 - -180 ) / 4.294967295E9;
					double bias = -180;
					
					m_P2_Longitude= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isP2_AltitudeValid()
			{
				if (checkPresenceVector(1))
				{
					return true;
				}
				return false;
			}
			
			public double getP2_Altitude()
			{
				double value;
				
				double scaleFactor = ( 35000 - -10000 ) / 4.294967295E9;
				double bias = -10000;
				
				value = m_P2_Altitude * scaleFactor + bias;
				
				return value;
			}
			
			public void setP2_Altitude(double value)
			{
				if ((value >= -10000) && (value <= 35000))
				{
					double scaleFactor = ( 35000 - -10000 ) / 4.294967295E9;
					double bias = -10000;
					
					m_P2_Altitude= (long)((value - bias) / scaleFactor);
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
				bytes.putInt(pos, (int) m_P1_Latitude);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_P1_Longitude);
				pos += JausUtils.getNumBytes("int");
				if (checkPresenceVector(0))
				{
					bytes.putInt(pos, (int) m_P1_Altitude);
					pos += JausUtils.getNumBytes("int");
				}
				bytes.putInt(pos, (int) m_P2_Latitude);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_P2_Longitude);
				pos += JausUtils.getNumBytes("int");
				if (checkPresenceVector(1))
				{
					bytes.putInt(pos, (int) m_P2_Altitude);
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
				m_P1_Latitude = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_P1_Longitude = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				if (checkPresenceVector(0))
				{
					m_P1_Altitude = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
				m_P2_Latitude = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_P2_Longitude = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				if (checkPresenceVector(1))
				{
					m_P2_Altitude = bytes.getInt(pos) & 0xffffffffL;
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
			
			public ReportGlobalPathSegment.Body.GlobalPathSegmentRec assign(GlobalPathSegmentRec value)
			{
				m_PresenceVector = value.m_PresenceVector;
				m_P1_Latitude = value.m_P1_Latitude;
				m_P1_Longitude = value.m_P1_Longitude;
				m_P1_Altitude = value.m_P1_Altitude;
				m_P2_Latitude = value.m_P2_Latitude;
				m_P2_Longitude = value.m_P2_Longitude;
				m_P2_Altitude = value.m_P2_Altitude;
				m_WeightingFactor = value.m_WeightingFactor;
				m_PathTolerance = value.m_PathTolerance;
				
				return this;
			}
			
			public boolean isEqual(GlobalPathSegmentRec value)
			{
				if (!m_PresenceVector.equals(value.m_PresenceVector))
				{
					return false;
				}
				if (m_P1_Latitude != value.getP1_Latitude())
				{
					return false;
				}
				if (m_P1_Longitude != value.getP1_Longitude())
				{
					return false;
				}
				if (m_P1_Altitude != value.getP1_Altitude())
				{
					return false;
				}
				if (m_P2_Latitude != value.getP2_Latitude())
				{
					return false;
				}
				if (m_P2_Longitude != value.getP2_Longitude())
				{
					return false;
				}
				if (m_P2_Altitude != value.getP2_Altitude())
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
			
			public boolean notEquals(GlobalPathSegmentRec value)
			{
				return !this.isEqual(value);
			}
			
			public GlobalPathSegmentRec()
			{
				m_parent = null;
				m_PresenceVector = new BitSet();
				m_PresenceVectorTemp = 0;
				m_P1_Latitude = 0;
				m_P1_Longitude = 0;
				m_P1_Altitude = 0;
				m_P2_Latitude = 0;
				m_P2_Longitude = 0;
				m_P2_Altitude = 0;
				m_WeightingFactor = 0;
				m_PathTolerance = 0;
			}
			
			public GlobalPathSegmentRec(GlobalPathSegmentRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_PresenceVector = new BitSet();
				m_PresenceVectorTemp = 0;
				m_P1_Latitude = 0;
				m_P1_Longitude = 0;
				m_P1_Altitude = 0;
				m_P2_Latitude = 0;
				m_P2_Longitude = 0;
				m_P2_Altitude = 0;
				m_WeightingFactor = 0;
				m_PathTolerance = 0;
				
				/// Copy the values
				m_PresenceVector = value.m_PresenceVector;
				m_P1_Latitude = value.m_P1_Latitude;
				m_P1_Longitude = value.m_P1_Longitude;
				m_P1_Altitude = value.m_P1_Altitude;
				m_P2_Latitude = value.m_P2_Latitude;
				m_P2_Longitude = value.m_P2_Longitude;
				m_P2_Altitude = value.m_P2_Altitude;
				m_WeightingFactor = value.m_WeightingFactor;
				m_PathTolerance = value.m_PathTolerance;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected GlobalPathSegmentRec m_GlobalPathSegmentRec;
	
		public ReportGlobalPathSegment.Body.GlobalPathSegmentRec getGlobalPathSegmentRec()
		{
			return m_GlobalPathSegmentRec;
		}
		
		public void setGlobalPathSegmentRec(GlobalPathSegmentRec value)
		{
			m_GlobalPathSegmentRec = value;
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
			
			size += m_GlobalPathSegmentRec.getSize();
			
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
			
			m_GlobalPathSegmentRec.encode(bytes, pos);
			pos += m_GlobalPathSegmentRec.getSize();
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
			
			m_GlobalPathSegmentRec.decode(bytes, pos);
			pos += m_GlobalPathSegmentRec.getSize();
		}
		
		public ReportGlobalPathSegment.Body assign(Body value)
		{
			m_GlobalPathSegmentRec = value.m_GlobalPathSegmentRec;
			m_GlobalPathSegmentRec.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_GlobalPathSegmentRec.isEqual(value.getGlobalPathSegmentRec()))
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
			m_GlobalPathSegmentRec = new GlobalPathSegmentRec();
			m_GlobalPathSegmentRec.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_GlobalPathSegmentRec = new GlobalPathSegmentRec();
			m_GlobalPathSegmentRec.setParent(this);
			
			/// Copy the values
			m_GlobalPathSegmentRec = value.m_GlobalPathSegmentRec;
			m_GlobalPathSegmentRec.setParent(this);
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
	public ReportGlobalPathSegment.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public ReportGlobalPathSegment.Body getBody()
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
	
	public ReportGlobalPathSegment setAs(ReportGlobalPathSegment value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportGlobalPathSegment value)
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
	
	public boolean notEquals(ReportGlobalPathSegment value)
	{
		return !isEqual(value);
	}
	
	public ReportGlobalPathSegment()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportGlobalPathSegment(ReportGlobalPathSegment value)
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
