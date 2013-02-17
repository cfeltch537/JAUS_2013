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

public class QueryServiceList extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x2b04;
	
	public static class  MsgHeader
	{
		public static class  HeaderRec
		{
		
			protected MsgHeader m_parent;
			protected int m_MessageID;
		
			public void setParent(MsgHeader parent)
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
			
			public QueryServiceList.MsgHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x2b04;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x2b04;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public QueryServiceList.MsgHeader.HeaderRec getHeaderRec()
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
		
		public QueryServiceList.MsgHeader assign(MsgHeader value)
		{
			m_HeaderRec = value.m_HeaderRec;
			m_HeaderRec.setParent(this);
			
			return this;
		}
		
		public boolean isEqual(MsgHeader value)
		{
			if (!m_HeaderRec.isEqual(value.getHeaderRec()))
			{
				return false;
			}
			return true;
		}
		
		public boolean notEquals(MsgHeader value)
		{
			return !this.isEqual(value);
		}
		
		public MsgHeader()
		{
			m_HeaderRec = new HeaderRec();
			m_HeaderRec.setParent(this);
		}
		
		public MsgHeader(MsgHeader value)
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
		public static class  SubsystemList
		{
			public static class  SubsystemSeq
			{
				public static class  SubsystemRec
				{
				
					protected SubsystemSeq m_parent;
					protected int m_SubsystemID;
				
					public void setParent(SubsystemSeq parent)
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
					
					public int getSubsystemID()
					{
						return m_SubsystemID;
					}
					
					public void setSubsystemID(int value)
					{
						if (((value >= 1) && (value <= 65534)) || (value == 0) || (value == 65535))
						{
							m_SubsystemID = value;
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
						
						bytes.putShort(pos, (short) m_SubsystemID);
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
						
						m_SubsystemID = bytes.getShort(pos) & 0xffff;
						pos += JausUtils.getNumBytes("short");
					}
					
					public QueryServiceList.Body.SubsystemList.SubsystemSeq.SubsystemRec assign(SubsystemRec value)
					{
						m_SubsystemID = value.m_SubsystemID;
						
						return this;
					}
					
					public boolean isEqual(SubsystemRec value)
					{
						if (m_SubsystemID != value.getSubsystemID())
						{
							return false;
						}
						
						return true;
					}
					
					public boolean notEquals(SubsystemRec value)
					{
						return !this.isEqual(value);
					}
					
					public SubsystemRec()
					{
						m_parent = null;
						m_SubsystemID = 0;
					}
					
					public SubsystemRec(SubsystemRec value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_SubsystemID = 0;
						
						/// Copy the values
						m_SubsystemID = value.m_SubsystemID;
					}
					
					public void finalize()
					{
					}
					
				}
				public static class  NodeList
				{
					public static class  NodeSeq
					{
						public static class  NodeRec
						{
						
							protected NodeSeq m_parent;
							protected short m_NodeID;
						
							public void setParent(NodeSeq parent)
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
							
							public short getNodeID()
							{
								return m_NodeID;
							}
							
							public void setNodeID(short value)
							{
								if (((value >= 1) && (value <= 254)) || (value == 0) || (value == 255))
								{
									m_NodeID = value;
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
								
								bytes.put(pos, (byte) m_NodeID);
								pos += JausUtils.getNumBytes("byte");
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
								
								m_NodeID = (short) (bytes.get(pos) & 0xff);
								pos += JausUtils.getNumBytes("byte");
							}
							
							public QueryServiceList.Body.SubsystemList.SubsystemSeq.NodeList.NodeSeq.NodeRec assign(NodeRec value)
							{
								m_NodeID = value.m_NodeID;
								
								return this;
							}
							
							public boolean isEqual(NodeRec value)
							{
								if (m_NodeID != value.getNodeID())
								{
									return false;
								}
								
								return true;
							}
							
							public boolean notEquals(NodeRec value)
							{
								return !this.isEqual(value);
							}
							
							public NodeRec()
							{
								m_parent = null;
								m_NodeID = 0;
							}
							
							public NodeRec(NodeRec value)
							{
								/// Initiliaze the protected variables
								m_parent = null;
								m_NodeID = 0;
								
								/// Copy the values
								m_NodeID = value.m_NodeID;
							}
							
							public void finalize()
							{
							}
							
						}
						public static class  ComponentList
						{
							public static class  ComponentRec
							{
							
								protected ComponentList m_parent;
								protected BitSet m_PresenceVector;
								protected short m_PresenceVectorTemp;
								protected short m_ComponentID;
								protected String m_SearchFilter;
							
								public void setParent(ComponentList parent)
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
								
								public short getComponentID()
								{
									return m_ComponentID;
								}
								
								public void setComponentID(short value)
								{
									if (((value >= 1) && (value <= 254)) || (value == 0) || (value == 255))
									{
										m_ComponentID = value;
										setParentPresenceVector();
									}
									return;
								}
								
								public boolean isSearchFilterValid()
								{
									if (checkPresenceVector(0))
									{
										return true;
									}
									return false;
								}
								
								public String getSearchFilter()
								{
									return m_SearchFilter;
								}
								
								public void setSearchFilter(String value)
								{
									if ( value.length() > 255)
									{
										return;
									}
									
									m_SearchFilter = value;
									if (m_SearchFilter.length() < 0)
									{
										m_SearchFilter = m_SearchFilter.substring(0, 0);
									}
									setPresenceVector(0);
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
									
									size += JausUtils.getNumBytes("byte");
									size += JausUtils.getNumBytes("byte");
									if (checkPresenceVector(0))
									{
										size += JausUtils.getNumBytes("byte");
										size += m_SearchFilter.length();
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
									bytes.put(pos, (byte) m_ComponentID);
									pos += JausUtils.getNumBytes("byte");
									if (checkPresenceVector(0))
									{
										
										try
										{
										bytes.put(pos, (byte) m_SearchFilter.length());
										pos += JausUtils.getNumBytes("byte");
										
										char[] m_SearchFilterBytes = m_SearchFilter.toCharArray();
										for(int str_pos = 0; str_pos<m_SearchFilterBytes.length; str_pos++)
										{
											bytes.put(pos, (byte) m_SearchFilterBytes[str_pos]);
											pos++;
										}
										}
										catch (Exception e)
										{
											
										}
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
									m_ComponentID = (short) (bytes.get(pos) & 0xff);
									pos += JausUtils.getNumBytes("byte");
									if (checkPresenceVector(0))
									{
										
										short m_SearchFilterLength = 0;
										m_SearchFilterLength = (short) (bytes.get(pos) & 0xff);
										pos += JausUtils.getNumBytes("byte");
										
										
										// Decoding the string m_SearchFilterfrom the buffer.
										char[] m_SearchFilterBytes = new char[(int)m_SearchFilterLength];
										for(int decode_pos = 0; decode_pos<(int)m_SearchFilterLength;decode_pos++)
										{
											m_SearchFilterBytes[decode_pos] = (char) (bytes.get(pos) &0xff);
											pos++;
										}
										m_SearchFilter = new String(m_SearchFilterBytes);
									}
								}
								
								public QueryServiceList.Body.SubsystemList.SubsystemSeq.NodeList.NodeSeq.ComponentList.ComponentRec assign(ComponentRec value)
								{
									m_PresenceVector = value.m_PresenceVector;
									m_ComponentID = value.m_ComponentID;
									m_SearchFilter = value.m_SearchFilter;
									
									return this;
								}
								
								public boolean isEqual(ComponentRec value)
								{
									if (!m_PresenceVector.equals(value.m_PresenceVector))
									{
										return false;
									}
									if (m_ComponentID != value.getComponentID())
									{
										return false;
									}
									if ((m_SearchFilter.length() != value.m_SearchFilter.length()) || (m_SearchFilter.compareTo(value.m_SearchFilter) != 0))
									{
										return false;
									}
									
									return true;
								}
								
								public boolean notEquals(ComponentRec value)
								{
									return !this.isEqual(value);
								}
								
								public ComponentRec()
								{
									m_parent = null;
									m_PresenceVector = new BitSet();
									m_PresenceVectorTemp = 0;
									m_ComponentID = 0;
									m_SearchFilter = new String();
								}
								
								public ComponentRec(ComponentRec value)
								{
									/// Initiliaze the protected variables
									m_parent = null;
									m_PresenceVector = new BitSet();
									m_PresenceVectorTemp = 0;
									m_ComponentID = 0;
									m_SearchFilter = new String();
									
									/// Copy the values
									m_PresenceVector = value.m_PresenceVector;
									m_ComponentID = value.m_ComponentID;
									m_SearchFilter = value.m_SearchFilter;
								}
								
								public void finalize()
								{
								}
								
							}
						
						
							protected NodeSeq m_parent;
							protected ArrayList<ComponentRec> m_ComponentRec;
						
							public void setParent(NodeSeq parent)
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
							
							public long getNumberOfElements()
							{
								return (long) m_ComponentRec.size();
							}
							
							public QueryServiceList.Body.SubsystemList.SubsystemSeq.NodeList.NodeSeq.ComponentList.ComponentRec getElement(int index)
							{
								return m_ComponentRec.get(index);
							}
							
							public void setElement(int index, ComponentRec value)
							{
								if(m_ComponentRec.size()-1 < index)
								{
									return;
								}
								
								m_ComponentRec.set(index, value);
								m_ComponentRec.get(index).setParent(this);
								setParentPresenceVector();
							}
							
							public void addElement(ComponentRec value)
							{
								m_ComponentRec.add(value);
								m_ComponentRec.get(m_ComponentRec.size() -1 ).setParent(this);
								setParentPresenceVector();
							}
							
							public int deleteElement(int index)
							{
								if(m_ComponentRec.size()-1 < index)
								{
									return 1;
								}
								
								m_ComponentRec.remove(index);
								return 0;
							}
							
							public int deleteLastElement()
							{
								m_ComponentRec.remove(m_ComponentRec.size()-1);
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
								long size = 0;
								
								size += JausUtils.getNumBytes("byte");
								for (int i = 0; i < m_ComponentRec.size(); i++)
								{
									size += m_ComponentRec.get(i).getSize();
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
								
								short size = (short) m_ComponentRec.size();
								bytes.put(pos, (byte) size);
								pos += JausUtils.getNumBytes("byte");
								for (int i = 0; i < m_ComponentRec.size(); i++)
								{
									m_ComponentRec.get(i).encode(bytes, pos);
									pos += m_ComponentRec.get(i).getSize();
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
								
								short size;
								size = (short) (bytes.get(pos) & 0xff);
								pos += JausUtils.getNumBytes("byte");
								m_ComponentRec = new ArrayList<ComponentRec>();
								for (int i = 0; i <  size; i++)
								{
									ComponentRec item = new ComponentRec();
									item.decode(bytes, pos);
									m_ComponentRec.add(item);
									pos += item.getSize();
								}
							}
							
							public QueryServiceList.Body.SubsystemList.SubsystemSeq.NodeList.NodeSeq.ComponentList assign(ComponentList value)
							{
								m_ComponentRec.clear();
								
								for (int i = 0; i < value.m_ComponentRec.size(); i++)
								{
									m_ComponentRec.add(value.m_ComponentRec.get(i));
									m_ComponentRec.get(i).setParent(this);
								}
								
								return this;
							}
							
							public boolean isEqual(ComponentList value)
							{
								for (int i = 0; i < m_ComponentRec.size(); i++)
								{
									if (!m_ComponentRec.get(i).isEqual(value.getElement(i)))
									{
										return false;
									}
								}
								
								return true;
							}
							
							public boolean notEquals(ComponentList value)
							{
								return !this.isEqual(value);
							}
							
							public ComponentList()
							{
								m_parent = null;
								m_ComponentRec = new ArrayList<ComponentRec>();
								for (int i = 0; i < m_ComponentRec.size(); i++)
								{
									m_ComponentRec.get(i).setParent(this);
								}
							}
							
							public ComponentList(ComponentList value)
							{
								/// Initiliaze the protected variables
								m_parent = null;
								m_ComponentRec = new ArrayList<ComponentRec>();
								for (int i = 0; i < m_ComponentRec.size(); i++)
								{
									m_ComponentRec.get(i).setParent(this);
								}
								
								/// Copy the values
								m_ComponentRec.clear();
								
								for (int i = 0; i < value.m_ComponentRec.size(); i++)
								{
									m_ComponentRec.add(value.m_ComponentRec.get(i));
									m_ComponentRec.get(i).setParent(this);
								}
							}
							
							public void finalize()
							{
							}
							
						}
					
					
						protected NodeList m_parent;
						protected NodeRec m_NodeRec;
						protected ComponentList m_ComponentList;
					
						public void setParent(NodeList parent)
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
						
						public QueryServiceList.Body.SubsystemList.SubsystemSeq.NodeList.NodeSeq.NodeRec getNodeRec()
						{
							return m_NodeRec;
						}
						
						public void setNodeRec(NodeRec value)
						{
							m_NodeRec = value;
							setParentPresenceVector();
						}
						
						public QueryServiceList.Body.SubsystemList.SubsystemSeq.NodeList.NodeSeq.ComponentList getComponentList()
						{
							return m_ComponentList;
						}
						
						public void setComponentList(ComponentList value)
						{
							m_ComponentList = value;
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
							
							size += m_NodeRec.getSize();
							size += m_ComponentList.getSize();
							
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
							
							m_NodeRec.encode(bytes, pos);
							pos += m_NodeRec.getSize();
							m_ComponentList.encode(bytes, pos);
							pos += m_ComponentList.getSize();
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
							
							m_NodeRec.decode(bytes, pos);
							pos += m_NodeRec.getSize();
							m_ComponentList.decode(bytes, pos);
							pos += m_ComponentList.getSize();
						}
						
						public QueryServiceList.Body.SubsystemList.SubsystemSeq.NodeList.NodeSeq assign(NodeSeq value)
						{
							m_NodeRec = value.m_NodeRec;
							m_NodeRec.setParent(this);
							m_NodeRec = value.m_NodeRec;
							m_ComponentList = value.m_ComponentList;
							m_ComponentList.setParent(this);
							m_ComponentList = value.m_ComponentList;
							
							return this;
						}
						
						public boolean isEqual(NodeSeq value)
						{
							if (!m_NodeRec.isEqual(value.getNodeRec()))
							{
								return false;
							}
							
							if (!m_NodeRec.isEqual(value.getNodeRec()))
							{
								return false;
							}
							if (!m_ComponentList.isEqual(value.m_ComponentList))
							{
								return false;
							}
							
							if (!m_ComponentList.isEqual(value.getComponentList()))
							{
								return false;
							}
							
							return true;
						}
						
						public boolean notEquals(NodeSeq value)
						{
							return !this.isEqual(value);
						}
						
						public NodeSeq()
						{
							m_parent = null;
							m_NodeRec = new NodeRec();
							m_NodeRec.setParent(this);
							m_ComponentList = new ComponentList();
							m_ComponentList.setParent(this);
						}
						
						public NodeSeq(NodeSeq value)
						{
							/// Initiliaze the protected variables
							m_parent = null;
							m_NodeRec = new NodeRec();
							m_NodeRec.setParent(this);
							m_ComponentList = new ComponentList();
							m_ComponentList.setParent(this);
							
							/// Copy the values
							m_NodeRec = value.m_NodeRec;
							m_NodeRec.setParent(this);
							m_NodeRec = value.m_NodeRec;
							m_ComponentList = value.m_ComponentList;
							m_ComponentList.setParent(this);
							m_ComponentList = value.m_ComponentList;
						}
						
						public void finalize()
						{
						}
						
					}
				
				
					protected SubsystemSeq m_parent;
					protected ArrayList<NodeSeq> m_NodeSeq;
				
					public void setParent(SubsystemSeq parent)
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
					
					public int getNumberOfElements()
					{
						return m_NodeSeq.size();
					}
					
					public QueryServiceList.Body.SubsystemList.SubsystemSeq.NodeList.NodeSeq getElement(int index)
					{
						return m_NodeSeq.get(index);
					}
					
					public void setElement(int index, NodeSeq value)
					{
						if(m_NodeSeq.size()-1 < index)
						{
							return;
						}
						
						m_NodeSeq.set(index, value);
						m_NodeSeq.get(index).setParent(this);
						setParentPresenceVector();
					}
					
					public void addElement(NodeSeq value)
					{
						m_NodeSeq.add(value);
						m_NodeSeq.get(m_NodeSeq.size() -1).setParent(this);
						setParentPresenceVector();
					}
					
					public int deleteElement(int index)
					{
						if(m_NodeSeq.size()-1 < index)
						{
							return 1;
						}
						
						m_NodeSeq.remove(index);
						return 0;
					}
					
					public int deleteLastElement()
					{
						m_NodeSeq.remove(m_NodeSeq.size() -1);
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
						long size = 0;
						
						size += JausUtils.getNumBytes("byte");
						for (int i = 0; i < m_NodeSeq.size(); i++)
						{
							size += m_NodeSeq.get(i).getSize();
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
						
						short size = (short) m_NodeSeq.size();
						bytes.put(pos, (byte) size);
						pos += JausUtils.getNumBytes("byte");
						for (int i = 0; i < m_NodeSeq.size(); i++)
						{
							m_NodeSeq.get(i).encode(bytes, pos);
							pos += m_NodeSeq.get(i).getSize();
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
						
						short size;
						size = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
						m_NodeSeq = new ArrayList<NodeSeq>();
						for (int i = 0; i <  size; i++)
						{
							NodeSeq item = new NodeSeq();
							item.decode(bytes, pos);
							m_NodeSeq.add(item);
							pos += item.getSize();
						}
					}
					
					public QueryServiceList.Body.SubsystemList.SubsystemSeq.NodeList assign(NodeList value)
					{
						m_NodeSeq.clear();
						
						for (int i = 0; i < value.m_NodeSeq.size(); i++)
						{
							m_NodeSeq.add(value.m_NodeSeq.get(i));
							m_NodeSeq.get(i).setParent(this);
						}
						
						return this;
					}
					
					public boolean isEqual(NodeList value)
					{
						for (int i = 0; i < m_NodeSeq.size(); i++)
						{
							if (!m_NodeSeq.get(i).isEqual(value.m_NodeSeq.get(i)))
							{
								return false;
							}
						}
						
						return true;
					}
					
					public boolean notEquals(NodeList value)
					{
						return !this.isEqual(value);
					}
					
					public NodeList()
					{
						m_parent = null;
						m_NodeSeq = new ArrayList<NodeSeq>();
						for (int i = 0; i < m_NodeSeq.size(); i++)
						{
							m_NodeSeq.get(i).setParent(this);
						}
					}
					
					public NodeList(NodeList value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_NodeSeq = new ArrayList<NodeSeq>();
						for (int i = 0; i < m_NodeSeq.size(); i++)
						{
							m_NodeSeq.get(i).setParent(this);
						}
						
						/// Copy the values
						m_NodeSeq.clear();
						
						for (int i = 0; i < value.m_NodeSeq.size(); i++)
						{
							m_NodeSeq.add(value.m_NodeSeq.get(i));
							m_NodeSeq.get(i).setParent(this);
						}
					}
					
					public void finalize()
					{
					}
					
				}
			
			
				protected SubsystemList m_parent;
				protected SubsystemRec m_SubsystemRec;
				protected NodeList m_NodeList;
			
				public void setParent(SubsystemList parent)
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
				
				public QueryServiceList.Body.SubsystemList.SubsystemSeq.SubsystemRec getSubsystemRec()
				{
					return m_SubsystemRec;
				}
				
				public void setSubsystemRec(SubsystemRec value)
				{
					m_SubsystemRec = value;
					setParentPresenceVector();
				}
				
				public QueryServiceList.Body.SubsystemList.SubsystemSeq.NodeList getNodeList()
				{
					return m_NodeList;
				}
				
				public void setNodeList(NodeList value)
				{
					m_NodeList = value;
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
					
					size += m_SubsystemRec.getSize();
					size += m_NodeList.getSize();
					
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
					
					m_SubsystemRec.encode(bytes, pos);
					pos += m_SubsystemRec.getSize();
					m_NodeList.encode(bytes, pos);
					pos += m_NodeList.getSize();
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
					
					m_SubsystemRec.decode(bytes, pos);
					pos += m_SubsystemRec.getSize();
					m_NodeList.decode(bytes, pos);
					pos += m_NodeList.getSize();
				}
				
				public QueryServiceList.Body.SubsystemList.SubsystemSeq assign(SubsystemSeq value)
				{
					m_SubsystemRec = value.m_SubsystemRec;
					m_SubsystemRec.setParent(this);
					m_SubsystemRec = value.m_SubsystemRec;
					m_NodeList = value.m_NodeList;
					m_NodeList.setParent(this);
					m_NodeList = value.m_NodeList;
					
					return this;
				}
				
				public boolean isEqual(SubsystemSeq value)
				{
					if (!m_SubsystemRec.isEqual(value.getSubsystemRec()))
					{
						return false;
					}
					
					if (!m_SubsystemRec.isEqual(value.getSubsystemRec()))
					{
						return false;
					}
					if (!m_NodeList.isEqual(value.m_NodeList))
					{
						return false;
					}
					
					if (!m_NodeList.isEqual(value.getNodeList()))
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(SubsystemSeq value)
				{
					return !this.isEqual(value);
				}
				
				public SubsystemSeq()
				{
					m_parent = null;
					m_SubsystemRec = new SubsystemRec();
					m_SubsystemRec.setParent(this);
					m_NodeList = new NodeList();
					m_NodeList.setParent(this);
				}
				
				public SubsystemSeq(SubsystemSeq value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_SubsystemRec = new SubsystemRec();
					m_SubsystemRec.setParent(this);
					m_NodeList = new NodeList();
					m_NodeList.setParent(this);
					
					/// Copy the values
					m_SubsystemRec = value.m_SubsystemRec;
					m_SubsystemRec.setParent(this);
					m_SubsystemRec = value.m_SubsystemRec;
					m_NodeList = value.m_NodeList;
					m_NodeList.setParent(this);
					m_NodeList = value.m_NodeList;
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected ArrayList<SubsystemSeq> m_SubsystemSeq;
		
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
			
			public int getNumberOfElements()
			{
				return m_SubsystemSeq.size();
			}
			
			public QueryServiceList.Body.SubsystemList.SubsystemSeq getElement(int index)
			{
				return m_SubsystemSeq.get(index);
			}
			
			public void setElement(int index, SubsystemSeq value)
			{
				if(m_SubsystemSeq.size()-1 < index)
				{
					return;
				}
				
				m_SubsystemSeq.set(index, value);
				m_SubsystemSeq.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(SubsystemSeq value)
			{
				m_SubsystemSeq.add(value);
				m_SubsystemSeq.get(m_SubsystemSeq.size() -1).setParent(this);
				setParentPresenceVector();
			}
			
			public int deleteElement(int index)
			{
				if(m_SubsystemSeq.size()-1 < index)
				{
					return 1;
				}
				
				m_SubsystemSeq.remove(index);
				return 0;
			}
			
			public int deleteLastElement()
			{
				m_SubsystemSeq.remove(m_SubsystemSeq.size() -1);
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
				long size = 0;
				
				size += JausUtils.getNumBytes("short");
				for (int i = 0; i < m_SubsystemSeq.size(); i++)
				{
					size += m_SubsystemSeq.get(i).getSize();
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
				
				int size = (int) m_SubsystemSeq.size();
				bytes.putShort(pos, (short) size);
				pos += JausUtils.getNumBytes("short");
				for (int i = 0; i < m_SubsystemSeq.size(); i++)
				{
					m_SubsystemSeq.get(i).encode(bytes, pos);
					pos += m_SubsystemSeq.get(i).getSize();
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
				
				int size;
				size = bytes.getShort(pos) & 0xffff;
				pos += JausUtils.getNumBytes("short");
				m_SubsystemSeq = new ArrayList<SubsystemSeq>();
				for (int i = 0; i <  size; i++)
				{
					SubsystemSeq item = new SubsystemSeq();
					item.decode(bytes, pos);
					m_SubsystemSeq.add(item);
					pos += item.getSize();
				}
			}
			
			public QueryServiceList.Body.SubsystemList assign(SubsystemList value)
			{
				m_SubsystemSeq.clear();
				
				for (int i = 0; i < value.m_SubsystemSeq.size(); i++)
				{
					m_SubsystemSeq.add(value.m_SubsystemSeq.get(i));
					m_SubsystemSeq.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(SubsystemList value)
			{
				for (int i = 0; i < m_SubsystemSeq.size(); i++)
				{
					if (!m_SubsystemSeq.get(i).isEqual(value.m_SubsystemSeq.get(i)))
					{
						return false;
					}
				}
				
				return true;
			}
			
			public boolean notEquals(SubsystemList value)
			{
				return !this.isEqual(value);
			}
			
			public SubsystemList()
			{
				m_parent = null;
				m_SubsystemSeq = new ArrayList<SubsystemSeq>();
				for (int i = 0; i < m_SubsystemSeq.size(); i++)
				{
					m_SubsystemSeq.get(i).setParent(this);
				}
			}
			
			public SubsystemList(SubsystemList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_SubsystemSeq = new ArrayList<SubsystemSeq>();
				for (int i = 0; i < m_SubsystemSeq.size(); i++)
				{
					m_SubsystemSeq.get(i).setParent(this);
				}
				
				/// Copy the values
				m_SubsystemSeq.clear();
				
				for (int i = 0; i < value.m_SubsystemSeq.size(); i++)
				{
					m_SubsystemSeq.add(value.m_SubsystemSeq.get(i));
					m_SubsystemSeq.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected SubsystemList m_SubsystemList;
	
		public QueryServiceList.Body.SubsystemList getSubsystemList()
		{
			return m_SubsystemList;
		}
		
		public void setSubsystemList(SubsystemList value)
		{
			m_SubsystemList = value;
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
			
			size += m_SubsystemList.getSize();
			
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
			
			m_SubsystemList.encode(bytes, pos);
			pos += m_SubsystemList.getSize();
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
			
			m_SubsystemList.decode(bytes, pos);
			pos += m_SubsystemList.getSize();
		}
		
		public QueryServiceList.Body assign(Body value)
		{
			m_SubsystemList = value.m_SubsystemList;
			m_SubsystemList.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_SubsystemList.isEqual(value.m_SubsystemList))
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
			m_SubsystemList = new SubsystemList();
			m_SubsystemList.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_SubsystemList = new SubsystemList();
			m_SubsystemList.setParent(this);
			
			/// Copy the values
			m_SubsystemList = value.m_SubsystemList;
			m_SubsystemList.setParent(this);
			/// This code is currently not supported
		}
		
		public void finalize()
		{
		}
		
	}
	protected MsgHeader m_MsgHeader;
	protected Body m_Body;
	public long getID()
	{
	return ID;
 }
	public QueryServiceList.MsgHeader getMsgHeader()
	{
		return m_MsgHeader;
	}
	
	public void setMsgHeader(MsgHeader value)
	{
		m_MsgHeader = value;
	}
	
	public QueryServiceList.Body getBody()
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
		
		size += m_MsgHeader.getSize();
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
		
		m_MsgHeader.encode(bytes, pos);
		pos += m_MsgHeader.getSize();
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
		
		m_MsgHeader.decode(bytes, pos);
		pos += m_MsgHeader.getSize();
		m_Body.decode(bytes, pos);
		pos += m_Body.getSize();
	}
	
	public QueryServiceList setAs(QueryServiceList value)
	{
		m_MsgHeader = value.m_MsgHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(QueryServiceList value)
	{
		if (!m_MsgHeader.isEqual(value.getMsgHeader()))
		{
			return false;
		}
		if (!m_Body.isEqual(value.getBody()))
		{
			return false;
		}
		
		return true;
	}
	
	public boolean notEquals(QueryServiceList value)
	{
		return !isEqual(value);
	}
	
	public QueryServiceList()
	{
		m_MsgHeader = new MsgHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  QueryServiceList(QueryServiceList value)
	{
		/// Initiliaze the protected variables
		m_MsgHeader = new MsgHeader();
		m_Body = new Body();
		m_IsCommand = false;
		
		/// Copy the values
		m_MsgHeader = value.m_MsgHeader;
		m_Body = value.m_Body;
	}
	
}
